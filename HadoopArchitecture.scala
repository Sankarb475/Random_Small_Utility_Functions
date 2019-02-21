// HADOOP 3.0
===========================================================================================================================
Hadoop HA ==> 
In order for the Standby node to keep its state synchronized with the Active node, both nodes communicate with a group of 
separate daemons called “JournalNodes” (JNs). When any namespace modification is performed by the Active node, it durably 
logs a record of the modification to a majority of these JNs. The Standby node is capable of reading the edits from the JNs, 
and is constantly watching them for changes to the edit log. As the Standby Node sees the edits, it applies them to its own 
namespace. In the event of a failover, the Standby will ensure that it has read all of the edits from the JounalNodes before 
promoting itself to the Active state. This ensures that the namespace state is fully synchronized before a failover occurs.

In order to provide a fast failover, it is also necessary that the Standby node have up-to-date information regarding the 
location of blocks in the cluster. In order to achieve this, the DataNodes are configured with the location of all NameNodes, 
and send block location information and heartbeats to all.

-- we should always have an odd number of replicas or JournalNodes in order to actually increase the number of failures the 
system can tolerate, since edit log modifications must be written to a majority of JNs. Also we always want to have a fault
tolerant system where majority number of process are working fine. So replication factor minimum 3 does make sense. One failure
will leave us 2 working systems, that is majority number.
In some cases, when client is writing something in HDFS, only when in majority number of replicas has been created it sends
back the confirmation email to the client.

-- Hadoop configuration set up for Pseuo distributed mode.

1) core-site.xml ==> contains information such as the port number used for Hadoop instance, memory allocated for the file 
                     system, memory limit for storing the data, and size of Read/Write buffers.
                     <configuration>
                        <property>
                          <name>fs.default.name</name>
                          <value>hdfs://localhost:9000</value> 
                        </property>
                      </configuration>

2) hdfs-site.xml ==> contains information such as the value of replication data, namenode path, and datanode paths of your 
                     local file systems
                     property name :: dfs.replication
                     also provide datanode(dfs.data.dir) and namenode(dfs.name.dir) path
                     
3) mapred-site.xml ==> mapreduce framework we are using, mapreduce.framework.name :: yarn

4) yarn-site.xml ==> confogures yarn. yarn.nodemanager.aux-services :: mapreduce_shuffle


*** Rack Awareness ***
HDFS block placement will use rack awareness for fault tolerance by placing one block replica on a different rack. This 
provides data availability in the event of a network switch failure or partition within the cluster.

NFS ==> Network File System

                     
