package example.micronaut.entity
import javax.persistence.*
@Entity(name="employee")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,
    @Column
    val name: String? = null
)