package com.okawa.minichat.ui.model

data class MessageModel(val messageId: Long?,
                        val content: String?,
                        val userId: Long?,
                        val username: String?,
                        val userAvatar: String?,
                        val isAttachment: Boolean = false,
                        val attachmentId: String? = "",
                        val attachmentUrl: String? = "",
                        val attachmentThumbnail: String? = "")