import com.github.xjs.protobuffdemo.nano.BaseProto;
import com.github.xjs.protobuffdemo.nano.PersonProto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wtt
 * @create: 2020/07/02
 */
public class Test {
//    @org.junit.Test
////    public void testPersonSerialize() throws Exception{
////        Person p = new Person();
////        p.setName("张三");
////        p.setAge(30);
////        byte[] bytes = ProtobuffUtil.toBytes(ProtobuffUtil.toNano(p, PersonProto.Person.class));
////        System.out.println("bytes.length:"+bytes.length);//10
////        p = ProtobuffUtil.toBean(ProtobuffUtil.fromBytes(bytes, PersonProto.Person.class), Person.class);
////        System.out.println(p.getName() + "," + p.getAge());
////    }
    @org.junit.Test
    public void test(){
        PersonProto.Person person = PersonProto.Person.newBuilder().setId(2).setName("test")
                .setEmail("test@163.com").build();
        byte[] results = person.toByteArray();
        for (byte b : results) {
            System.out.println(String.valueOf(b));
        }
    }

    @org.junit.Test
    public void test2(){
        PersonProto.Person.china build = PersonProto.Person.china.newBuilder().setArea(1234).setMoney("234234").setType(PersonProto.Person.PhoneType.WORK).build();
        BaseProto.MsgBaseData msg = BaseProto.MsgBaseData.newBuilder().setObject(1).build();
        List<String> positions = new ArrayList<>();
        positions.add("test");
        positions.add("test2");
        PersonProto.Person person = PersonProto.Person.newBuilder().setId(2).setName("test").setBaseProto(msg)
                .setEmail("test@163.com").setNation(build).putAddress("123","345").addAllPosition(positions).build();
        System.out.println(person);
    }
}
