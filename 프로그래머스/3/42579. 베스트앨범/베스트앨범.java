import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> gc = new HashMap<>();
        Map<String, Queue<Song>> gs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            Song song = new Song(i, playCount, genre);
            
            gc.put(genre, gc.getOrDefault(genre, 0) + playCount);
            if (gs.keySet().contains(genre)) {
                gs.get(genre).add(song);
            } else {
                Queue<Song> songs = new PriorityQueue<>();
                songs.offer(song);
                gs.put(genre, songs);
            }
        }
        
        List<Genre> gl = new ArrayList<>();
        for (String g : gc.keySet()) {
            gl.add(new Genre(g, gc.get(g)));
        }
        
        Collections.sort(gl);
        
        List<Integer> answer = new ArrayList<>();
        for (Genre g : gl) {
            Queue<Song> q = gs.get(g.genre);
            for (int i = 0; i < 2 && !q.isEmpty(); i++) {
                Song song = gs.get(g.genre).poll();
                answer.add(song.id);
            }
        }
        
        int[] ra = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ra[i] = answer.get(i);
        }
        
        return ra;
    }
    
    private static class Genre implements Comparable<Genre> {
        String genre;
        int playCount;
        
        public Genre(String genre, int playCount) {
            this.genre = genre;
            this.playCount = playCount;
        }
        
        @Override
        public int compareTo(Genre other) {
            return other.playCount - this.playCount;
        }
    }
    
    private static class Song implements Comparable<Song> {
        int id;
        int playCount;
        String genre;
        
        public Song(int id, int playCount, String genre) {
            this.id = id;
            this.playCount = playCount;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Song other) {
            if (other.playCount == this.playCount) {
                return this.id - other.id;
            }
            return other.playCount - this.playCount;
        }
    }
}