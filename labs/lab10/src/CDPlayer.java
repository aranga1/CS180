//import java.util.ArrayList;

/**
 * Class CDPlayer
 */
public class CDPlayer extends MusicPlayer {
    
    private int deviceID;
    private int thisTrack;
    
    /**
     * Constructor for CD-Player
     */
    public CDPlayer(int id) {
    	super();
    	this.deviceID = id;
        System.out.println("Creating CDPlayer: " + deviceID);
        
        //Define your constructor here
        //Add code here
        
        
        
    }
    
    /**
     * Over-ride Method: turnOn
     */
    public void turnOn() {
        System.out.println("CDPlayer Powering ON");
        if (this.status == OFF)
            this.thisTrack = 0;
        this.status = ON;
    }
    
    /**
     * Over-ride Method: turnOff
     */
    
    public void turnOff() {
        System.out.println("CDPlayer Powering OFF");
        this.status = OFF;
        thisTrack = 0;
    }
    
    /**
     * Method to play next track in the playlist
     */
    
    public void nextTrack() {
        //add your code here.
    	thisTrack++;
        if (thisTrack >= this.playlist.size() || thisTrack >= this.PLAYLIST_SIZE) {
            System.out.println("End of playlist!");
            this.thisTrack = 0;
        }
        System.out.println("Now Playing: " + this.playlist.get(thisTrack));
        
    }
    
    /**
     * Method to play previous track in the playlist
     */
    
    public void previousTrack() {
        thisTrack--;
        if (thisTrack >= this.playlist.size() || thisTrack >= this.PLAYLIST_SIZE || thisTrack < 0)  {
            System.out.println("This is the first song! No More previous songs! ");
            thisTrack = 0;
            return;
        }
        System.out.println("Now Playing: " + this.playlist.get(this.thisTrack));
        
        
    }
    
    /**
     * Method to play track in playlist by trackname
     */
    
    public void play(int trackNumber) {
        
        if (trackNumber >= this.playlist.size() || trackNumber >= this.PLAYLIST_SIZE || trackNumber < 0) {
            System.out.println("Please enter valid trackNo. " + trackNumber + "!");
            this.status = OFF;
            return;
        }
        System.out.println("Now Playing: " + playlist.get(trackNumber));
        thisTrack = trackNumber;
        this.status = PLAYING;
        
    }
    
}