package models


sealed class ApiResponse(open val result: Any) {

    data object Init : ApiResponse(Any())
    data object Loading : ApiResponse(Any())
    data class Success(override val result: Any) : ApiResponse(result)

    sealed class Error(open val errorBody: String) : ApiResponse(errorBody) {
        data class Auth(override val errorBody: String) : Error(errorBody)
        data class Internal(val code: Int, override val errorBody: String) : Error("Status code: $code. Error: $errorBody")
        data class Connection(override val errorBody: String) : Error(errorBody)
    }

}

public inline fun ApiResponse.doOnSuccess(action: (Any) -> Unit) {
    if (this is ApiResponse.Success) {
        action(result)
    }
}

public inline fun ApiResponse.doOnError(action: (Any) -> Unit) {
    if (this is ApiResponse.Error) {
        action(result)
    }
}
