package example.micronaut.resource

import example.micronaut.entity.Employee
import io.micronaut.http.annotation.*
import example.micronaut.services.EmployeeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject

@Controller("/api/employee")
class EmployeeController {

    @Inject
    lateinit var profileService: EmployeeService

    @Post("/save")
    fun save(@Body profile: Employee): Employee {
        log.info("Saving Profile :{}", profile)
        return profileService.save(profile)
    }

    @Get("/get")
    fun findById(id: Long): Employee {
        log.info("Finding Profile: {}", id)
        return profileService.findById(id)
    }

    @Delete("/delete/{id}")
    fun deleteById(id: Long): Boolean {
        log.info("Deleting Profile: {}", id)
        return profileService.deleteById(id)
    }

    @Get("/findAll")
    fun findAll(): Iterable<Employee> {
        log.info("find All")
        return profileService.findAll()
    }

    @Put("/update")
    fun update(@Body profile: Employee): Employee {
        log.info("update {}", profile)
        return profileService.update(profile)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(EmployeeController::class.java)
    }
}