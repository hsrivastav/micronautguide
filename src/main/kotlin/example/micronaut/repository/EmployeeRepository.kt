package example.micronaut.repository

import example.micronaut.entity.Employee
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository


@Repository
interface EmployeeRepository : CrudRepository<Employee, Long> {

}