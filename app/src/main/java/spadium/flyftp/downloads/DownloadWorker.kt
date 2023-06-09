package spadium.flyftp.downloads

import android.app.NotificationManager
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class DownloadWorker(context: Context, parameters: WorkerParameters) :
    CoroutineWorker(context, parameters) {
        private val notifManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as
                    NotificationManager

        override suspend fun doWork(): Result {
            TODO("Not yet implemented")
        }
}