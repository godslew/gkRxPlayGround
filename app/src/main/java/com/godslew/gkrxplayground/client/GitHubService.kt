package com.godslew.gkrxplayground.client

import com.godslew.gkrxplayground.entity.Repos
import com.godslew.gkrxplayground.entity.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject


class GitHubClient @Inject constructor(
    private val service : GitHubService
) {
    fun getUser(user : String) : Single<User> {
        return service.getUser(user)
    }

    fun getRepos(user: String) : Single<List<Repos>> {
        return service.listRepos(user)
    }

    interface GitHubService {
        /**
         * ユーザの情報を取得する
         * https://developer.github.com/v3/users/#get-a-single-user
         */
        @GET("users/{username}")
        fun getUser(@Path("username") user: String): Single<User>

        /**
         * ユーザのリポジトリ一覧を取得する
         * https://developer.github.com/v3/repos/#list-user-repositories
         */
        @GET("users/{user}/repos")
        fun listRepos(@Path("user") user: String): Single<List<Repos>>
    }
}