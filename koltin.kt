private fun saveImageToInternalStorage(bitmap: Bitmap): Uri{
        val wrapper = ContextWrapper(applicationContext)
        // now we are going to define the of directory
        // and it's type which is private meaning, files
        // won't be accessible outside the application
        var file = wrapper.getDir("IMAGE_DIRECTORY",
            Context.MODE_PRIVATE )
        // now generating the file with random username
        file = File(file, "${UUID.randomUUID()}.jpg")


        try {

            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()

        }catch (e: IOException){
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)
    }
