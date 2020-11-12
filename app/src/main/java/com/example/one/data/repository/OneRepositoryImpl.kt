package com.example.one.data.repository

import android.util.Log
import com.example.one.data.entity.*
import com.example.one.data.model.*
import com.example.one.data.remote.OneResult
import com.example.one.data.remote.OneService
import com.orhanobut.logger.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


/**
 * <pre>
 *     author: dhl
 *     date  : 2020/7/11
 *     desc  :
 * </pre>
 */

class OneRepositoryImpl(
    val api: OneService
) : Repository {

    override suspend fun getHomeData(): Flow<OneResult<HomeModel>> {
        return flow {
            try {
                val homeResponse: HomeResponse = api.getHomeData()
                var homeModel: HomeModel
                homeResponse.data.let {
                    homeModel = HomeModel(
                        imgUrl = it.content_list[0].img_url,
                        imgTxt = it.content_list[0].forward,
                        imgAuthor = it.content_list[0].words_info,
                        contentImgurl = it.content_list[1].img_url,
                        contentTitle = it.content_list[1].title,
                        contentTxt = it.content_list[1].forward,
                        contentAuthor = it.content_list[1].author.user_name,
                        contentId = it.content_list[1].item_id
                        )
                }
                emit(OneResult.Success(homeModel))
            } catch (e: Exception) {
                emit(OneResult.Failure(e.cause))
            }

        }.flowOn(Dispatchers.IO)

    }

    override suspend fun getQuestion(): Flow<OneResult<QuestionModel>>{
        val date = SimpleDateFormat("yyyy-MM").format(Date())
        return flow {
            try {
                val questionResponse:QuestionResponse = api.getQuestion(date)
                val questionModel = QuestionModel(ArrayList<QuestionModel.QuestionItemModel>())
                questionResponse.data.let {
                    it.forEach {
                        val questionItemModel = QuestionModel.QuestionItemModel(
                            qId = it.id,
                            qTitle = it.title,
                            qSubTitle =  it.subtitle,
                            qImgUrl = it.cover
                        )
                        questionModel.data.add(questionItemModel)
                    }
                }
                emit(OneResult.Success(questionModel))
            } catch (e:Exception){
                emit(OneResult.Failure(e.cause))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getSerialize(): Flow<OneResult<SerializeModel>> {
        val date = SimpleDateFormat("yyyy").format(Date())
        return flow {
            try {
                val serializeResponse:SerializeResponse = api.getSerialize(date)
                val serializeModel = SerializeModel(ArrayList<SerializeModel.SerializeItemModel>())
                serializeResponse.data.forEach {
                    val serializeItemModel = SerializeModel.SerializeItemModel(
                        id = it.id,
                        title = it.title,
                        subTitle = it.subtitle,
                        serial_id = it.serial_id,
                        imgUrl = it.cover,
                        content = it.forward,
                        finished = it.isFinished
                    )
                    serializeModel.data.add(serializeItemModel)
                }
                emit(OneResult.Success(serializeModel))
            } catch (e:Exception){
                emit(OneResult.Failure(e.cause))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getHtmlContent(
        item: String,
        id: String
    ): Flow<OneResult<HtmlContentModel>> {
        return flow {
            try {
                val htmlContentResponse: HtmlContentResponse = api.getHtmlContent(item,id)
                val htmlContentModel = HtmlContentModel(
                    title = htmlContentResponse.data.title,
                    content = htmlContentResponse.data.html_content.split("one-editor-box")[0]
                )
                emit(OneResult.Success(htmlContentModel))
            } catch (e:Exception){
                emit(OneResult.Failure(e.cause))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getComment(
        item: String,
        id: String
    ): Flow<OneResult<CommentModel>> {
        return flow {
            try {
                val commentResponse: CommentResponse = api.getComment(item,id)

                val commentModel = CommentModel(ArrayList<CommentModel.CommentItemModel>())

                commentResponse.data.data.forEach {
                    val commentItemModel = CommentModel.CommentItemModel(
                        userId = it.user_info_id,
                        userName = it.user.user_name,
                        userImg = it.user.web_url,
                        contentTxt = it.content,
                        praiseNum = it.praisenum,
                        publishTime = it.input_date
                    )
                    commentModel.data.add(commentItemModel)
                }

                emit(OneResult.Success(commentModel))
            } catch (e:Exception){
                emit(OneResult.Failure(e.cause))
            }
        }.flowOn(Dispatchers.IO)
    }

}