package com.github.nikdon.telepooz.model.methods

import java.time.Duration

import com.github.nikdon.telepooz.IsResourceId
import com.github.nikdon.telepooz.model.ReplyMarkup
import com.github.nikdon.telepooz.tags.{ChatId, FileId, MessageId}
import shapeless.tag.@@


/**
  * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document).
  * On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size, this limit
  * may be changed in the future.
  *
  * @param chat_id              Unique identifier for the target chat or username of the target channel
  *                             (in the format @channelusername)
  * @param video                Video to send. You can either pass a file_id as String to resend a video that is already
  *                             on the Telegram servers, or upload a new video file using multipart/form-data.
  * @param duration             Duration of sent video in seconds
  * @param width                Video width
  * @param height               Video height
  * @param caption              Video caption (may also be used when resending videos by file_id), 0-200 characters
  * @param disable_notification Sends the message silently. iOS users will not receive a notification, Android users
  *                             will receive a notification with no sound.
  * @param reply_to_message_id  If the message is a reply, ID of the original message
  * @param reply_markup         Additional interface options. A JSON-serialized object for an inline keyboard, custom
  *                             reply keyboard, instructions to hide reply keyboard or to force a reply from the user.
  */
case class SendVideo[A: IsResourceId](chat_id: A @@ ChatId,
                                      video: String @@ FileId, // TODO Add file upload
                                      duration: Option[Duration] = None,
                                      width: Option[Int] = None,
                                      height: Option[Int] = None,
                                      caption: Option[String] = None,
                                      disable_notification: Option[Boolean] = None,
                                      reply_to_message_id: Option[Long @@ MessageId] = None,
                                      reply_markup: Option[ReplyMarkup] = None)