package com.javanew;

public class ThreadPoolConfigFactoryExp {
	
 enum ThreadPoolConfigFactory {

    /**
     * ThreadPoolConfigFactory (corePoolSize,maxPoolSize,keepAliveTime)
     */
    
    PROCESSOR_TOR_THREADPOOL               (3,    Integer.MAX_VALUE,   60L), 
    BACKEND_TRANSACTIONS_THREADPOOL        (3,    Integer.MAX_VALUE,   60L), 
    ORACLE_DATABASE_THREADPOOL             (5,    Integer.MAX_VALUE,   60L), 
    MARIADB_DATABASE_THREADPOOL            (5,    Integer.MAX_VALUE,   60L), 
    PROCESSOR_PAUSE_THREADPOOL             (7,    Integer.MAX_VALUE,   60L),
    PROCESSOR_SPACE_THREADPOOL             (7,    Integer.MAX_VALUE,   60L),
    METRICS_THREADPOOL                     (2,    Integer.MAX_VALUE,   60L);
	 
//	NAME_OF_ENUMS 	(2,    Intege.MAX_VALUE,   60L );

    private final int corePoolSize;
    private final int maxPoolSize;
    private final long keepAliveTimeInSeconds;
//    private final String nameOfenum;

   ThreadPoolConfigFactory(int corePoolSize, int maxPoolSize, long keepAliveTimeInSeconds) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTimeInSeconds = keepAliveTimeInSeconds;
    }
    
//    ThreadPoolConfigFactory(int corePoolSize, int maxPoolSize, long keepAliveTimeInSeconds, String nameOfenum ) {
//        this.corePoolSize = corePoolSize;
//        this.maxPoolSize = maxPoolSize;
//        this.keepAliveTimeInSeconds = keepAliveTimeInSeconds;
//        this.nameOfenum = nameOfenum;
//    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public long getKeepAliveTimeInSeconds() {
        return keepAliveTimeInSeconds;
    }

}

	public static void main(String[] args) {

		 System.out.println(ThreadPoolConfigFactory.BACKEND_TRANSACTIONS_THREADPOOL.getCorePoolSize());
		 System.out.println(ThreadPoolConfigFactory.BACKEND_TRANSACTIONS_THREADPOOL.getMaxPoolSize());


	}

}
