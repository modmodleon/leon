package com.leon.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class TestSingleRedis {

	//��������һ��redisʱ
	private static Jedis jedis;
	//����ģʽ���ڱ�ģʽ
	private static ShardedJedis shard;
	//���ӳ�
	private static ShardedJedisPool pool;
	
}
