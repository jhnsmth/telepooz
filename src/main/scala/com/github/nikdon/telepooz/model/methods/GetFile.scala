package com.github.nikdon.telepooz.model.methods

import com.github.nikdon.telepooz.tags.FileId
import shapeless.tag.@@


/**
  * Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download
  * files of up to 20MB in size. On success, a File object is returned. The file can then be downloaded via the link
  * https://api.telegram.org/file/bot<token>/<file_path>, where <file_path> is taken from the response. It is guaranteed
  * that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling
  * getFile again.
  *
  * @param file_id  File identifier to get info about
  */
case class GetFile(file_id: String @@ FileId)