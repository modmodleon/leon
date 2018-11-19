package com.leon.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.User;
import com.leon.utils.FastJsonUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class TestMain {

	//单独连接一个redis时
	private static Jedis jedis;
	//主从模式，哨兵模式
	private static ShardedJedis shard;
	//连接池
	private static ShardedJedisPool pool;
	
	public static void main(String[] args) {
//		Jedis j = new Jedis("192.168.17.128", 6379);
//		System.out.println(j);
//		List<String> mget = j.mget("name","age");
//		System.out.println(mget);
	/*	Map user = new HashMap<>();
		user.put("name", "zhangsan");
		user.put("age", "155");
		user.put("hobby", "打炮");
		j.hmset("user", user);*/
//		List<String> hmget = j.hmget("user", "hobby");
//		System.out.println(hmget);
		
		method();
	}
	
	
	public static void method() {
		Jedis j = new Jedis("192.168.17.128", 6379);
		Map<String, String> map = new HashMap<>();
		
		final String SYS_TABLE_M="SYS_TABLE_M";
		final String SYS_TABLE_AGE="SYS_TABLE_AGE";
		
		Set<String> set = j.sinter(SYS_TABLE_M,SYS_TABLE_AGE);
		for(Iterator<String> it= set.iterator();it.hasNext(); ) {
			String next = it.next();
			String hget = j.hget("users", next);
			System.out.println(hget);
			User ss = (User) FastJsonUtils.convertJSONToObject(hget, User.class);
			System.out.println(ss.getName());
		}
		
		
		
//		Set<String> res = j.smembers(SYS_TABLE_M);
		
//		Iterator<String> it = res.iterator();
 
		/*for(Iterator<String> it = res.iterator();it.hasNext();) {
			String next = it.next();
			String hget = j.hget("users", next);
			System.out.println(hget);
		}*/
		
		
		
//		j.hmget("user", SYS_TABLE_M);
		
		
		/*String u1id =System.currentTimeMillis()+UUID.randomUUID().toString();
		User u1 = new User(u1id,"z3",12,"m");
		j.sadd(SYS_TABLE_M, u1id);
		
		String u2id =System.currentTimeMillis()+UUID.randomUUID().toString();
		User u2 = new User(u2id,"z4",11,"w");
		j.sadd(SYS_TABLE_AGE, u2id);
		
		String u3id =System.currentTimeMillis()+UUID.randomUUID().toString();
		User u3 = new User(u3id,"z5",11,"m");
		j.sadd(SYS_TABLE_M, u3id);
		j.sadd(SYS_TABLE_AGE, u3id);

		String u4id =System.currentTimeMillis()+UUID.randomUUID().toString();
		User u4 = new User(u4id,"z6",16,"w");
		map.put(u1id, FastJsonUtils.convertObjectToJSON(u1));
		map.put(u2id, FastJsonUtils.convertObjectToJSON(u2));
		map.put(u3id, FastJsonUtils.convertObjectToJSON(u3));
		map.put(u4id, FastJsonUtils.convertObjectToJSON(u4));
		System.out.println(u1id);
		j.hmset("users", map);*/
		
	}
}
