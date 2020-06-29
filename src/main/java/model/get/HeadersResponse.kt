package model.get

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.annotations.SerializedName


class HeadersResponse(
    @SerializedName("x-forwarded-proto") var xForwardedProto: String,
    @SerializedName("x-forwarded-port") var xForwardedPort: String,
    @SerializedName("host") var host: String,
    @SerializedName("x-amzn-trace-id") var xAmznTraceId: String,
    @SerializedName("accept") var accept: String,
    @SerializedName("content-length") var contentLength: String?,
    @SerializedName("content-type") var contentType: String?,
    @SerializedName("cookie") var cookie: String?,
    @SerializedName("user-agent") var userAgent: String,
    @SerializedName("accept-encoding") var acceptEncoding: String

)
