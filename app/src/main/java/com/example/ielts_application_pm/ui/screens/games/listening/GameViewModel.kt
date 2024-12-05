
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel() {
    private val originalVideos = listOf(

        Pair(
            "https://clip.cafe/videos/the-wilderness-must-be-explored.mp4",
            "The wilderness must be explored! CA-CA! RAAWWRR!"
        ),
        Pair(
            "https://clip.cafe/videos/an-intelligence-agency-fears-intelligence.mp4",
            "An intelligence agency that fears intelligence? Historically, not awesome."
        ),
        Pair(
            "https://clip.cafe/videos/oh-boy-are-in-a-show-tonight-son.mp4",
            "Oh, boy, you are in for a show tonight, son."
        ),
        Pair(
            "https://clip.cafe/videos/sen-i-said-you-a-klutz.mp4",
            "Sen! I'm sorry I called you a dope before... I take it back!"
        ),
        Pair(
            "https://clip.cafe/videos/are-trying-trick-me.mp4",
            "Are you trying to trick me? Et cetera? I'll tell on you!"
        ),
        Pair(
            "https://clip.cafe/videos/i-am-buzz-lightyear-i-come-in-peace.mp4",
            "I am Buzz Lightyear; I come in peace. Oh, I'm so glad you're not a dinosaur!"
        ),
        Pair(
            "https://clip.cafe/videos/whats-trust-setting.mp4",
            "What's your trust setting, TARS? Lower than yours, apparently"
        ),
        Pair(
            "https://clip.cafe/videos/we-need-a-plan-of-attack.mp4",
            "Stark, we need a plan of attack! attack! I have a plan: attack!"
        )
    )

    private val _videos = mutableListOf(*originalVideos.toTypedArray())
    private val _currentVideo = MutableStateFlow(_videos.first().first)
    val currentVideo: StateFlow<String> = _currentVideo

    private val _isVideoPlaying = MutableStateFlow(true)
    val isVideoPlaying: StateFlow<Boolean> = _isVideoPlaying

    private val _correctAnswer = mutableStateOf(_videos.first().second)
    val correctAnswer: State<String> = _correctAnswer

    private val _userAnswer = mutableStateOf<String?>(null)
    val userAnswer: State<String?> = _userAnswer

    fun onVideoEnd() {
        _isVideoPlaying.value = false
    }

    fun onSubmitAnswer(answer: String) {
        _userAnswer.value = answer
    }

    fun nextVideo() {
        if (_videos.isNotEmpty()) {
            _videos.removeAt(0) // Remove the played video
            if (_videos.isNotEmpty()) {
                _currentVideo.value = _videos.first().first
                _correctAnswer.value = _videos.first().second
                _userAnswer.value = null
                _isVideoPlaying.value = true
            }
        }
    }

    fun resetGame() {
        _videos.clear()
        _videos.addAll(originalVideos) // Reset the videos to the original list
        _currentVideo.value = _videos.first().first
        _correctAnswer.value = _videos.first().second
        _userAnswer.value = null
        _isVideoPlaying.value = true
    }

    fun addVideo(videoUrl: String, correctAnswer: String) {
        _videos.add(Pair(videoUrl, correctAnswer))
    }
}
