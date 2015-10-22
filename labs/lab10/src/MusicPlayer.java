import java.util.ArrayList;

/**
 * Main MusicPlayer class
 */
public class MusicPlayer {
    
    protected ArrayList<String> playlist = new ArrayList<String>();
    protected int status;
    protected int volume;
    
    static final int OFF = 0;
    static final int ON = 1;
    static final int PLAYING = 10;
    static final int VOLUME_MAX = 100;
    static final int VOLUME_MIN = 0;
    static final int PLAYLIST_SIZE = 10;
    
    public MusicPlayer() {
        volume = VOLUME_MIN;
        status = OFF;
        playlist.add("Words");
        playlist.add("Stairway To Heaven");
        playlist.add("Dream On");
        playlist.add("Thrift Shop");
        playlist.add("Buzzcut Season");
    }
    
    /**
     * play: Plays track from playlist based on mentioned trackNo
     *
     */
    public void play(int trackNo) {
        if (trackNo < 0 || trackNo >= this.PLAYLIST_SIZE
            || trackNo >= this.playlist.size()) {
            System.out.println("Track Number " + trackNo + " invalid!");
            status = OFF;
        }
        System.out.println("Playing " + this.playlist.get(trackNo));
        status = PLAYING;
        
    }
    
    /**
     * turnOn: Turn the player on
     *
     */
    
    public void turnOn() {
        
        this.status = ON;
        
    }
    
    /**
     * turnOff: Turn the player off
     *
     */
    
    public void turnOff() {
        status = OFF;
    }
    
    /**
     * adjustVolume: increase or decrease volume based on input
     *
     */
    
    public void adjustVolume(char ch, int value) {
        // Implement code to identify volume operation based on ch parameter
        // perform the volume operation by calling one out of methods
        // increaseVolume or decreseVolume.
        // You will have to check for multiple exceptions when performing this
        // operation
    	if (ch == '+') {
    		try {
    			increaseVolume(value);
    		} catch (VolumeOverFlowException e) {
    			System.out.printf(e.getMessage());
    		}
    	}
    	else if (ch == '-') {
    		try {
    			decreaseVolume(value);
    		} catch (VolumeUnderFlowException e) {
    			System.out.printf(e.getMessage());
    		}
    	}
        
    }
    
    /**
     * increaseVolume: Method to increase volume- called by adjustVolume
     *
     */
    
    public void increaseVolume(int increment) throws VolumeOverFlowException {
        volume += increment;
        if (volume > VOLUME_MAX)
            throw new VolumeOverFlowException("Volume_MAX. That's TOO LOUD!");
    }
    
    /**
     * decreaseVolume: Method to decrease volume- called by adjustVolume
     *
     */
    
    public void decreaseVolume(int decrement) throws VolumeUnderFlowException {
        volume -= decrement;
        if (volume < VOLUME_MIN)
            throw new VolumeUnderFlowException("Volume_MIN \n");
    }
    
    /**
     * showPlaylist: Displays current playlist
     *
     */
    public void showPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Your playlist is empty! Please add more songs!");
            return;
        } else {
            for (int i = 0; i < this.playlist.size(); i++) {
                System.out.println("-" + playlist.get(i));
            }
        }
    }
    
    /**
     * Main method
     *
     */
    
    public static void main(String[] args) {
        
        System.out.println("\nCDPlayer");
        CDPlayer cd1 = new CDPlayer(1234);
        cd1.turnOn();
        System.out.println("\nCDPlayer Playlist:");
        cd1.showPlaylist();
        cd1.adjustVolume('+', 20);
        cd1.play(1);
        cd1.nextTrack();
        cd1.previousTrack();
        cd1.play(21);
        cd1.adjustVolume('-', 30); // less than VOLUMN_MIN
        cd1.turnOff();
        
        System.out.println("\nEthernetPlayer");
        EthernetPlayer mp1 = new EthernetPlayer(123);
        mp1.turnOn();
        System.out.println("the playlist has: " + mp1.playlist.size()
                           + " songs");
        
        mp1.adjustVolume('+', 50);
        mp1.play(2);
        mp1.play(21);
        try {
            mp1.addToPlaylist("Broken");
        } catch (ExceedsCapacityException e) {
            System.out.println(e.getMessage());
        }
        try {
            mp1.addToPlaylist("Sweet Child'O Mine");
        } catch (ExceedsCapacityException e) {
            System.out.println(e.getMessage());
        }
        try {
            mp1.deleteFromPlaylist("Broken");
        } catch (TrackNotFoundException e) {
            System.out.println(e.getMessage());
        }
        mp1.download("haha"); // not in the download list.
        mp1.download("Dark Horse");
        mp1.download("Royals");
        mp1.download("Let Her Go");
        mp1.download("The Fox");
        mp1.download("Counting Stars"); // too many songs in the playlist
        
        mp1.adjustVolume('+', 60); // too loud
        
        System.out.println("\n\nEthernetPlayer Playlist:");
        mp1.showPlaylist();
        
        mp1.turnOff();
        
    }
    
}
