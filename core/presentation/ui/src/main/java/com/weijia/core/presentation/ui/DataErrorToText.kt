package com.weijia.core.presentation.ui

import com.weijia.core.domain.utils.DataError

fun DataError.asUiText(): UiText {
    return when(this) {
        DataError.Local.DISK_FULL -> UiText.StringResources(
            R.string.error_disk_full
        )
        DataError.Local.NO_PERMISSION -> UiText.StringResources(
            R.string.error_no_permission
        )
        DataError.Network.REQUEST_TIMEOUT -> UiText.StringResources(
            R.string.error_request_timeout
        )
        DataError.Network.TOO_MANY_REQUESTS -> UiText.StringResources(
            R.string.error_too_many_requests
        )
        DataError.Network.NO_INTERNET -> UiText.StringResources(
            R.string.error_no_internet
        )
        DataError.Network.PAYLOAD_TOO_LARGE -> UiText.StringResources(
            R.string.error_payload_too_large
        )
        DataError.Network.SERVER_ERROR -> UiText.StringResources(
            R.string.error_server_error
        )
        DataError.Network.SERIALIZATION -> UiText.StringResources(
            R.string.error_serialization
        )
        else -> UiText.StringResources(
            R.string.error_unknown
        )
    }
}