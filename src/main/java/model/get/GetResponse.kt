package model.get

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.annotations.SerializedName


class GetResponse(
    @SerializedName("args") var args: Args,
    @SerializedName("headers") var headers: HeadersResponse,
    @SerializedName("url") var url: String
)