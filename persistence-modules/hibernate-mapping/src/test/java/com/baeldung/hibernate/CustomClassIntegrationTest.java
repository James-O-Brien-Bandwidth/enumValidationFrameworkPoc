package com.baeldung.hibernate;

import com.baeldung.hibernate.entities.Department;
import com.baeldung.hibernate.entities.DeptEmployee;
import com.baeldung.hibernate.entities.Did;
import com.baeldung.hibernate.entities.DidGroup;
import com.baeldung.hibernate.entities.TestClass;
import com.baeldung.hibernate.pojo.DidGroupDtoWithPhoneNumbers;
import com.baeldung.hibernate.pojo.Result;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomClassIntegrationTest {

    private Session session;

    private Transaction transaction;

    @BeforeEach
    public void setUp() throws IOException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.createNativeQuery("delete from department").executeUpdate();
        Department department1 = new Department("Sales");
        DeptEmployee employee1 = new DeptEmployee("John Smith", "001", department1);
        session.persist(department1);
        session.persist(employee1);
        transaction.commit();

        transaction = session.beginTransaction();
        DeptEmployee employee2 = new DeptEmployee("Larry David", "002", department1);
        session.persist(employee2);
        transaction.commit();

        transaction = session.beginTransaction();
        Department department3 = new Department("Ads");
        DeptEmployee employee3 = new DeptEmployee("Bobby Magee", "003", department3);
        session.persist(department3);
        session.persist(employee3);
        transaction.commit();

        transaction = session.beginTransaction();
        DidGroup didGroup55 = new DidGroup("tierLevel 1");
        DidGroup didGroup77 = new DidGroup("tierLevel 2");
        Did did1 = new Did("101", "444445", didGroup55);
        Did did2 = new Did("102", "444446", didGroup55);
        Did did3 = new Did("103", "444447", didGroup55);
        Did did4 = new Did("104", "444448", didGroup77);
        TestClass testClass = new TestClass("tierLevel 1");
        session.persist(testClass);
//        session.persist(didGroup55);
//        session.persist(didGroup77);
//        session.persist(did1);
//        session.persist(did2);
//        session.persist(did3);
//        session.persist(did4);
        transaction.commit();


        transaction = session.beginTransaction();
    }

    @Test
    public void whenAllManagersAreSelected_ThenObjectGraphIsReturned() {
        Query<DeptEmployee> query = session.createQuery("from com.baeldung.hibernate.entities.DeptEmployee");
        List<DeptEmployee> deptEmployees = query.list();
        DeptEmployee deptEmployee = deptEmployees.get(0);
        assertEquals("John Smith", deptEmployee.getEmployeeName());
        assertEquals("Sales", deptEmployee.getDepartment().getName());
    }

    @Test
    public void whenIndividualPropertiesAreSelected_ThenObjectArrayIsReturned() {
        Query query = session.createQuery("select m.employeeName, m.department.name from com.baeldung.hibernate.entities.DeptEmployee m");
        List managers = query.list();
        Object[] manager = (Object[]) managers.get(0);
        assertEquals("John Smith", manager[0]);
        assertEquals("Sales", manager[1]);
    }

    @Test
    public void whenResultConstructorInSelect_ThenListOfResultIsReturned() {
        Query<Result> query = session.createQuery("select new com.baeldung.hibernate.pojo.Result(m.employeeName, m.department.name) from DeptEmployee m");
        List<Result> results = query.list();
        Result result = results.get(0);
        assertEquals("John Smith", result.getEmployeeName());
        assertEquals("Sales", result.getDepartmentName());
    }

    @Test
    public void whenResultConstructorInSelect_ThenListOfResultIsReturned_originalWithSomeDiffs() {
        Query<Result> query = session.createQuery("select new com.baeldung.hibernate.pojo.Result(m.department.id, m.employeeName, m.department.name) from DeptEmployee m where m.employeeName ='John Smith' ");
        List<Result> results = query.list();
        Result result = results.get(0);
        assertEquals("John Smith", result.getEmployeeName());
        assertEquals("Sales", result.getDepartmentName());
    }

    //DID = DeptEmployee
    //DidGroup = Department

    @Test
    public void findAllEmployeesWhereDepartmentIdIs1() {
        Query<Result> query = session.createQuery("select new com.baeldung.hibernate.pojo.Result(m.department.id, m.employeeName, m.department.name) from DeptEmployee m where m.department.id =1 ");
        List<Result> results = query.list();
        Result result = results.get(0);
        assertEquals("John Smith", result.getEmployeeName());
        assertEquals("Sales", result.getDepartmentName());
    }

    @Test
    public void findAllE164WhereDidGroupIs4() {
        Query<DidGroupDtoWithPhoneNumbers> query = session.createQuery("select new com.baeldung.hibernate.pojo.DidGroupDtoWithPhoneNumbers(m.didGroup.id, m.e164) from Did m where m.didGroup.id =1 ");
        List<DidGroupDtoWithPhoneNumbers> results = query.list();
        assertEquals(3, results.size());
        assertEquals(1, results.get(0).getDidGroupId());

        assertEquals("444445", results.get(0).getE164());
        assertEquals("444446", results.get(1).getE164());
        assertEquals("444447", results.get(2).getE164());
    }


}
