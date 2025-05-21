package project.metabaskbe

import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * User Table
 * address : 지갑주소
 * nonce : 아무값
 */
data class User(
    val address : String,
    val nonce : String = UUID.randomUUID().toString()
)

/**
 * UserService 생성하기
 */
@Service
class UserService{

    private val users = ConcurrentHashMap<String, User>()

    fun register(user: User) {
        users[user.address] = user
    }

    fun findByAddress(address: String): User? {
        return users[address]
    }


}