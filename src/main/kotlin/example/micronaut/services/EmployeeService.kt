package example.micronaut.services
import example.micronaut.entity.Employee
import example.micronaut.repository.EmployeeRepository
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
@Transactional
open class EmployeeService {

    @Inject
     open lateinit var employeeRepository: EmployeeRepository

    open fun save(profile: Employee): Employee {
        log.info("Saving Profile :{}", profile)
        employeeRepository.save(profile)
        return profile
    }

    open fun findById(id: Long): Employee {
        log.info("Finding Profile by id:{}", id)
        return employeeRepository.findById(id).orElse(null)
    }

    open fun deleteById(id: Long): Boolean {
        try {
            employeeRepository.deleteById(id)
            log.info("Deleting Profile by id:{}", id)
            return true
        } catch (e: Exception) {
            log.error("Failed to delete Profile by id:{}", id)
            e.printStackTrace()
            return false
        }
    }

    open fun findAll(): Iterable<Employee> {
        log.info("Find All")
        return employeeRepository.findAll()
    }

    open fun update(profile: Employee): Employee {
        log.info("update {}", profile)
        return employeeRepository.update(profile)

    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(EmployeeService::class.java)
    }
}