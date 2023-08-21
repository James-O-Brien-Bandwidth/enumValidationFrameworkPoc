## Java Bean Validation Examples

This module contains articles about Bean Validation.

### Relevant Articles: 
- [Java Bean Validation Basics](https://www.baeldung.com/javax-validation)
- [Validating Container Elements with Bean Validation 2.0](https://www.baeldung.com/bean-validation-container-elements)
- [Validations for Enum Types](https://www.baeldung.com/javax-validations-enums)
- [Javax BigDecimal Validation](https://www.baeldung.com/javax-bigdecimal-validation)
- [Grouping Javax Validation Constraints](https://www.baeldung.com/javax-validation-groups)
- [Constraint Composition with Bean Validation](https://www.baeldung.com/java-bean-validation-constraint-composition)
- [Using @NotNull on a Method Parameter](https://www.baeldung.com/java-notnull-method-parameter)
- More articles: [[next -->]](../javaxval-2)

# CURL example
curl --location 'http://localhost:8099/api/register' \
--header 'Content-Type: application/json' \
--data-raw '[
{
"username": "test_53fbb027ef71",
"email": "jobrien@bandwidth.com",
"age": 30,
"customerTypeString": "OLD"
},
{
"username": "test_53fbb027ef71",
"email": "jobrien@bandwidth.com",
"age": 30,
"customerTypeString": "asdasdasd"
},
{
"username": "test_53fbb027ef71",
"email": "jobrien@bandwidth.com",
"age": 30,
"customerTypeString": "NEW"
},
{
"username": "test_53fbb027ef71",
"email": "jobrien@bandwidth.com",
"age": 30,
"customerTypeString": "asdasdasdasd"
},
{
"username": "test_53fbb027ef71",
"email": "jobrien@bandwidth.com",
"age": 30,
"customerTypeString": "zxczxczxczxc"
}
]'
