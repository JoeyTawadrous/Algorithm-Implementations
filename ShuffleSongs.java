package algorithms;

import java.util.LinkedList;
import java.util.List;


/**
 * Shuffles songs in a play list.
 * 
 * @author joeytawadrous
 */
public class ShuffleSongs 
{
    static List<Song> songsList;

    @SuppressWarnings("unchecked")
	public static void main(String[] args) 
    {
        initSongsList();
        System.out.println("Before Shuffle");
        printSongsList(songsList);
        
        
        System.out.println("After Shuffle 1");
        printSongsList(shuffle1(songsList));
        
        
        initSongsList();
        System.out.println("After Shuffle 2");
        printSongsList(shuffle2(songsList));
    }

    private static void initSongsList()
    {
        songsList = new LinkedList<Song>();
        songsList.add(new Song("Moon Light", "Nature", "AL"));
        songsList.add(new Song("Go Next", "Future", "J. J"));
        songsList.add(new Song("Fear", "Hell G.", "SD"));
        songsList.add(new Song("My name is", "Future", "Khan"));
        songsList.add(new Song("My Lord", "K", "Ali"));
    } 
    
    /**
     * Prints lit of songs.
     * @param list
     */
    private static void printSongsList(List<Song> list)
    {
        for (int i = 0; i < list.size(); i++) 
        {
            Song song = list.get(i);
            System.out.printf("# %d - Title: %13s | Album: %10s | Artist: %10s\n", i+1, song.title, song.album, song.artist);
        }
        
        System.out.println("-------------------------------------------------------------------");
    }
    
    /**
     * Shuffles a play list. O(n)
     * @param list
     * @return resultList
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static List shuffle1(List list)
    {
        List resultList = new LinkedList();
        int size = list.size();
        int rand = 0;
        Object[] temp = list.toArray();
        int count = 0;
        
        while(count != size)
        {
            rand = (int)(Math.random()*list.size());
            if(!resultList.contains(temp[rand]))
            {
                resultList.add(temp[rand]);
                count++;
            }
        }
        
        return resultList;
    }
    
    /**
     * Shuffles a play list using recursion. O(log n)
     * @param list
     * @return resultList
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static List shuffle2(List list)
    {
        if(list.size() == 1)
        {
            return list;
        }
        else
        {
            int rand = (int)(Math.random()*list.size());
            Object song = list.remove(rand);
            
            list = shuffle2(list);
            list.add(song);
            
            return list;
        }
    }
    
    /**
     * Inner class.
     * @author joeytawadrous
     */
    private static class Song
    {
        private String title;
        private String album;
        private String artist;

        public Song(String title, String album, String artist) 
        {
            this.title = title;
            this.album = album;
            this.artist = artist;
        }       
    }
}