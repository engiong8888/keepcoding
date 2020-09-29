package cn.keep.coding.base.utils;

import java.net.InetAddress;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueKeyUtil {
	protected static Logger logger = LoggerFactory.getLogger(UniqueKeyUtil.class);
	private static SecureRandom seederStatic = null;
    private static byte addr[] = null;
    private static String midValueStatic = null;
    private String midValue = null;
    private SecureRandom seeder = null;

    static {
        try {
            addr = InetAddress.getLocalHost().getAddress();
            StringBuffer buffer = new StringBuffer(8);
            buffer.append(toHex(toInt(addr), 8));
            midValueStatic = buffer.toString();
            seederStatic = new SecureRandom();
            seederStatic.nextInt();
        } catch (Exception ex) {
        	logger.error("",ex);
        }
    }

    public UniqueKeyUtil() {
        StringBuffer buffer = new StringBuffer(16);
        buffer.append(midValueStatic);
        buffer.append(toHex(System.identityHashCode(this), 8));
        midValue = buffer.toString();
        seeder = new SecureRandom();
        seeder.nextInt();
    }

    /**
     * 以下函数在并发数大时，可能会产生重复
    public static String getKey() {
        String strResult = "";
        String strKey = (new VMID()).toString();
        for (int i = 0; i < strKey.length(); i++) {
            char ch = strKey.charAt(i);
            if (ch != ':' && ch != '-')
                strResult = strResult + ch;
        }

        return strResult;

    }
	*/


    /**
     * 该方法用来产生一个32位的唯一的标记String
     * @param obj 传入一个参考的对象
     * @return
     */
    public static String getKey(Object obj) {
        StringBuffer uid = new StringBuffer(32);

        //get the system time
        long currentTimeMillis = System.currentTimeMillis();
        uid.append(toHex((int)(currentTimeMillis & -1L), 8));

        // get the internet address
        uid.append(midValueStatic);

        //get the object hash value
        uid.append(toHex(System.identityHashCode(obj), 8));

        //get the random number
        uid.append(toHex(getRandom(), 8));

        return uid.toString();
    }

    /**
     * 该方法用来产生一个32位的String唯一标记
     * @return
     */
    public static String getKey() {
        StringBuffer uid = new StringBuffer(32);

        //get the system time
        long currentTimeMillis = System.currentTimeMillis();
        uid.append(toHex((int)(currentTimeMillis & -1L), 8));

        // get the internet address
        uid.append(midValueStatic);

        //get the random number
        uid.append(toHex(getRandom(), 8));

        return uid.toString();
    }

    private static String toHex(int value, int length) {
        char hexDigits[] = 
        { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 
          'E', 'F' };
        StringBuffer buffer = new StringBuffer(length);
        int shift = length - 1 << 2;
        for (int i = -1; ++i < length; ) {
            buffer.append(hexDigits[value >> shift & 0xf]);
            value <<= 4;
        }

        return buffer.toString();
    }

    private static int toInt(byte[] bytes) {
        int value = 0;
        for (int i = -1; ++i < bytes.length; ) {
            value <<= 8;
            value |= 0x00FF & bytes[i];
        }

        return value;
    }

    private static synchronized int getRandom() {
        return seederStatic.nextInt();
    }

    /*public static void main(String[] args) throws UnknownHostException {
    	System.out.println(UniqueKeyUtil.getKey(new Date()));
    }*/
}
