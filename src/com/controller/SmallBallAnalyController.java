package src.com.controller;

import com.jfinal.core.Controller;
import src.com.service.SmallBallAnalyService;

import java.util.HashMap;
import java.util.Map;

public class SmallBallAnalyController extends Controller {
    public void index() {
        int mount = getParaToInt("mount");
        SmallBallAnalyService sbas = new SmallBallAnalyService(mount);
//        String[] smallball_aly_result = sbas.get_sixteen();
        Map<String,Integer> map = sbas.get_sixteen_map();
        Map<String,Object> map2 =new HashMap<>();
        map2.put("success",true);
        map2.put("list",map);

//        for(Map.Entry<String,Integer> e:entrySet){
//            System.out.println(e.getKey()+":"+e.getValue());
//            setAttr(e.getKey(),e.getValue());
//        }


        renderJson(map2);
        return;
    }
}
