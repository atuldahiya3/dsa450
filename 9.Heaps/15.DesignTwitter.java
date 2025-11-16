class Twitter {
    Map<Integer, HashSet<Integer>> following;
    Map<Integer, List<long[]>> tweets;
    private static long timeStamp = 0;
    public Twitter() {
        following= new HashMap<>();
        tweets= new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k-> new ArrayList<>()).add(new long[]{timeStamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<long[]> q= new PriorityQueue<>((a,b)-> Long.compare(b[0], a[0]));
        HashSet<Integer> followingList= following.getOrDefault(userId, new HashSet<>());
        followingList.add(userId);
        List<Integer> most10recentTweets= new ArrayList<>();
        for(int f: followingList){
            List<long[]> tw= tweets.getOrDefault(f, new ArrayList<>()); 
            for(long[] t: tw){
                q.offer(t);
            }
        }
        int count=0;
        while(!q.isEmpty() && count<10){
            most10recentTweets.add((int) q.poll()[1]);
            count++;
        }
        return most10recentTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */