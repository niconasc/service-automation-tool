package model.post

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.annotations.SerializedName

class FormResponse(
    @SerializedName("foo1") var foo1: String?,
    @SerializedName("foo2") var foo2: String?
)