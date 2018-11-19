package com.leon.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class TestSingleRedis {

	//单独连接一个redis时
	private static Jedis jedis;
	//主从模式，哨兵模式
	private static ShardedJedis shard;
	//连接池
	private static ShardedJedisPool pool;
	
}
