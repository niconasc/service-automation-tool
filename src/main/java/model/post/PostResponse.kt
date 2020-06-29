package model.post

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.annotations.SerializedName
import model.get.Args
import model.get.HeadersResponse

class PostResponse(
    @SerializedName("args") var args: Args?,
    @SerializedName("data") var data: String,
    @SerializedName("files") var files: FilesResponse?,
    @SerializedName("form") var form: FormResponse?,
    @SerializedName("headers") var headers: HeadersResponse,
    @SerializedName("json") var json: JsonResponse?,
    @SerializedName("url") var url: String
)