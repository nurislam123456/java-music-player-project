import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

public class MusicPlayer {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File[] songs = {
                new File("Мирбек Атабеков - Кечки Бишкек (Official Video).wav"),
                new File("Гуф - Для Нее.wav"),
                new File("Silent Night - The Soundlings.wav")
        };

        Clip clip = AudioSystem.getClip();
        int idx = 0;
        clip.open(AudioSystem.getAudioInputStream(songs[idx]));

        while (true) {
            System.out.println("P = Play, S = Stop, N = Next, Q = Quit");
            String command = scanner.next().toUpperCase();
            if (command.equals("P")) {
                clip.start();
            } else if (command.equals("S")) {
                clip.stop();
            } else if (command.equals("N")) {
                clip.stop();
                clip.close();
                idx = (idx + 1) % songs.length;
                clip.open(AudioSystem.getAudioInputStream(songs[idx]));
                clip.start();
            } else if (command.equals("Q")) {
                clip.stop();
                clip.close();
                break;
            }
        }
    }
}