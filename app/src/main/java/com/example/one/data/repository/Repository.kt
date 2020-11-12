package com.example.one.data.repository

import com.example.one.data.model.*
import com.example.one.data.remote.OneResult
import kotlinx.coroutines.flow.Flow

/**
 * 数据仓库
 */
interface Repository {

    /**
     * 首页数据获取，返回kotlin协程Flow对象
     */
    suspend fun getHomeData(): Flow<OneResult<HomeModel>>

    /**
     * 问答数据获取
     */
    suspend fun getQuestion(): Flow<OneResult<QuestionModel>>

    /**
     * 连载数据获取
     */
    suspend fun getSerialize(): Flow<OneResult<SerializeModel>>

    /**
     * 文章内容获取
     */
    suspend fun getHtmlContent(
        item: String,
        id: String
    ): Flow<OneResult<HtmlContentModel>>

    suspend fun getComment(
        item: String,
        id: String
    ):Flow<OneResult<CommentModel>>
}