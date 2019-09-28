package com.example.vigotecth.server

import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.io.StringWriter

class MockDispatcher : Dispatcher() {

    private companion object FakeResponsesFiles {
        const val GROUPS = "Groups.json"
    }


    override fun dispatch(request: RecordedRequest): MockResponse {
        return when(request.path) {
            "/groups.json" -> responseFromFile(GROUPS)
            else -> throw UnsupportedOperationException("Request -> ${request.path}, not implemented")
        }
    }

    private fun responseFromFile(fileName: String): MockResponse {
        return MockResponse().apply {
            setResponseCode(200)
            setBody(loadFileAsAString(fileName))
        }
    }

    private fun loadFileAsAString(fileName: String): String {
        val context = InstrumentationRegistry.getInstrumentation().context
        val writer = StringWriter()
        val ins = context.assets.open(fileName) // Search.json
        IOUtils.copy(ins, writer, "UTF-8")
        val body = writer.toString()
        return body
    }
}