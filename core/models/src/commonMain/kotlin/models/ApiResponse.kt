package models


sealed class ApiResponse<out T> {
    data object Init : ApiResponse<Nothing>()
    data object Loading : ApiResponse<Nothing>()
    data class Success<out T>(val result: T) : ApiResponse<T>()

    sealed class Error(open val errorBody: String) : ApiResponse<Nothing>() {
        data class Auth(override val errorBody: String) : Error(errorBody)
        data class Internal(val code: Int, override val errorBody: String) : Error("Status code: $code. Error: $errorBody")
        data class Connection(override val errorBody: String) : Error(errorBody)
    }
}

public inline fun <reified T : Any> ApiResponse<T>.doOnSuccess(action: (T) -> Unit) {
    if (this is ApiResponse.Success<*> && result is T) {
        action(result)
    } else {
        throw Error("Expected ApiResponse.Success<${T::class.simpleName}>, but got $this")
    }
}

public inline fun ApiResponse<*>.doOnError(action: (String) -> Unit) {
    if (this is ApiResponse.Error) {
        action(errorBody)
    }
}
