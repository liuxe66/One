package com.example.one.data.remote

import com.example.one.data.entity.*
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * <pre>
 *     author: dhl
 *     date  : 2020/7/11
 *     desc  :
 * </pre>
 */
interface OneService {

    //首页
    @GET("channel/one/0/0")
    suspend fun getHomeData(): HomeResponse

    //问答
    //http://v3.wufazhuce.com:8000/api/find/bymonth/3/2020-09
    // ?channel=mx&sign=8739a869ff547839a50ddad201d1332a&version=5.1.1&uuid=00000000-07e0-7db3-ffff-ffff960e7198&platform=android
    @GET("find/bymonth/3/{date}?channel=mx&sign=8739a869ff547839a50ddad201d1332a&version=5.1.1&uuid=00000000-07e0-7db3-ffff-ffff960e7198&platform=android")
    suspend fun getQuestion(@Path("date") date: String): QuestionResponse

    //连载
    //http://v3.wufazhuce.com:8000/api/find/serial/byyear/2020?channel=mx&sign=8739a869ff547839a50ddad201d1332a&version=5.1.1&uuid=00000000-07e0-7db3-ffff-ffff960e7198&platform=android
    @GET("find/serial/byyear/{date}?channel=mx&sign=8739a869ff547839a50ddad201d1332a&version=5.1.1&uuid=00000000-07e0-7db3-ffff-ffff960e7198&platform=android")
    suspend fun getSerialize(@Path("date") date: String): SerializeResponse

    //文章详情
    //文章 essay 问答 question 连载 serialcontent
    //http://v3.wufazhuce.com:8000/api/question/htmlcontent/2978
    @GET("{item}/htmlcontent/{id}")
    suspend fun getHtmlContent(
        @Path("item") item: String,
        @Path("id") id: String
    ): HtmlContentResponse

    //文章评论
    //文章 essay 问答 question 连载 serialcontent
    //http://v3.wufazhuce.com:8000/api/comment/praiseandtime/essay/4446/0
    @GET("comment/praiseandtime/{item}/{id}/0")
    suspend fun getComment(
        @Path("item") item: String,
        @Path("id") id: String
    ):CommentResponse
}