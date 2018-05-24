package com.linyk3.test;


import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.linyk3.bean.UploadLocationRes;
import com.linyk3.service.BusService;
import com.linyk3.util.DateUtil;
import com.linyk3.util.MyHttpRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml","/spring-mybatis.xml"})
public class TestUserService_1_20180524 {

	Logger logger = Logger.getLogger(TestUserService_1_20180524.class);
   private String ip = "localhost:8080/BocbusServer/";
  // private String ip = "111.230.148.118:8080/BocbusServer/";
    
    @Autowired
    private BusService busService;

    
    @Test
    public void UpdateLocationController() throws Exception {
    	ArrayList<String> lons = new ArrayList<String>();;
    	ArrayList<String> lats = new ArrayList<String>();
    	lons.add("113.864627        "); lats.add("22.5735           ");
    	lons.add("113.86459391276041"); lats.add("22.574807942708333");
    	lons.add("113.86466498480902"); lats.add("22.574735785590278");
    	lons.add("113.86473117404513"); lats.add("22.57488986545139 ");
    	lons.add("113.86500244140625"); lats.add("22.575023871527776");
    	lons.add("113.86510172526042"); lats.add("22.575049913194444");
    	lons.add("113.86517605251736"); lats.add("22.57504421657986 ");
    	lons.add("113.86524088541667"); lats.add("22.57503824869792 ");
    	lons.add("113.8652671983507 "); lats.add("22.57513943142361 ");
    	lons.add("113.86562879774306"); lats.add("22.57457817925347 ");
    	lons.add("113.8655859375    "); lats.add("22.5747314453125  ");
    	lons.add("113.86567220052083"); lats.add("22.574800889756943");
    	lons.add("113.86569580078125"); lats.add("22.574783528645835");
    	lons.add("113.8658531358507 "); lats.add("22.574860026041666");
    	lons.add("113.86592420789931"); lats.add("22.574877387152778");
    	lons.add("113.86606065538194"); lats.add("22.575117730034723");
    	lons.add("113.8661607530382 "); lats.add("22.57518771701389 ");
    	lons.add("113.86606716579861"); lats.add("22.57529079861111 ");
    	lons.add("113.86615315755208"); lats.add("22.57535183376736 ");
    	lons.add("113.86594699435764"); lats.add("22.575689832899304");
    	lons.add("113.86601996527777"); lats.add("22.575643988715278");
    	lons.add("113.86593370225694"); lats.add("22.575604383680556");
    	lons.add("113.86652777777778"); lats.add("22.575447862413196");
    	lons.add("113.86658799913195"); lats.add("22.575215928819443");
    	lons.add("113.86620686848958"); lats.add("22.575533582899304");
    	lons.add("113.86628770616319"); lats.add("22.575494249131946");
    	lons.add("113.86633734809028"); lats.add("22.575503743489584");
    	lons.add("113.86661539713542"); lats.add("22.575428873697916");
    	lons.add("113.86660942925347"); lats.add("22.575511881510415");
    	lons.add("113.86638970269097"); lats.add("22.575604926215277");
    	lons.add("113.86627332899306"); lats.add("22.575551215277777");
    	lons.add("113.86626736111111"); lats.add("22.575533040364583");
    	lons.add("113.86637912326388"); lats.add("22.57565402560764 ");
    	lons.add("113.86654188368055"); lats.add("22.575704210069443");
    	lons.add("113.86651692708334"); lats.add("22.57566351996528 ");
    	lons.add("113.8665660264757 "); lats.add("22.575726182725695");
    	lons.add("113.86666395399305"); lats.add("22.575856119791666");
    	lons.add("113.86677083333333"); lats.add("22.575924479166666");
    	lons.add("113.86684678819445"); lats.add("22.575956217447917");
    	lons.add("113.86692437065972"); lats.add("22.5760009765625  ");
    	lons.add("113.86701144748264"); lats.add("22.575984700520834");
    	lons.add("113.86705078125   "); lats.add("22.576048719618054");
    	lons.add("113.86711724175348"); lats.add("22.576120334201388");
    	lons.add("113.86716335720486"); lats.add("22.576204427083333");
    	lons.add("113.86722873263889"); lats.add("22.576312120225694");
    	lons.add("113.8672829861111 "); lats.add("22.576394585503472");
    	lons.add("113.86734619140626"); lats.add("22.57643581814236 ");
    	lons.add("113.8674232313368 "); lats.add("22.57645779079861 ");
    	lons.add("113.86750868055556"); lats.add("22.576486002604167");
    	lons.add("113.86755343967013"); lats.add("22.576541341145834");
    	lons.add("113.86761094835069"); lats.add("22.576587727864585");
    	lons.add("113.86763671875   "); lats.add("22.57667914496528 ");
    	lons.add("113.8676784939236 "); lats.add("22.576746961805554");
    	lons.add("113.86772569444445"); lats.add("22.57680230034722 ");
    	lons.add("113.86777913411458"); lats.add("22.576873101128474");
    	lons.add("113.86789794921874"); lats.add("22.57688205295139 ");
    	lons.add("113.86792751736111"); lats.add("22.576968044704863");
    	lons.add("113.86796576605903"); lats.add("22.577021484375   ");
    	lons.add("113.86798773871527"); lats.add("22.577049424913195");
    	lons.add("113.86804768880208"); lats.add("22.57704644097222 ");
    	lons.add("113.86805881076388"); lats.add("22.577063530815973");
    	lons.add("113.86807373046875"); lats.add("22.57709418402778 ");
    	lons.add("113.8680775282118 "); lats.add("22.57711344401042 ");
    	lons.add("113.86809624565973"); lats.add("22.577129720052085");
    	lons.add("113.86810302734375"); lats.add("22.57714138454861 ");
    	lons.add("113.86811930338541"); lats.add("22.57716281467014 ");
    	lons.add("113.86812662760417"); lats.add("22.57718044704861 ");
    	lons.add("113.86815619574652"); lats.add("22.577184787326388");
    	lons.add("113.86816786024306"); lats.add("22.57718777126736 ");
    	lons.add("113.86816351996528"); lats.add("22.57720431857639 ");
    	lons.add("113.86815945095486"); lats.add("22.577199164496527");
    	lons.add("113.86816541883681"); lats.add("22.577206759982637");
    	lons.add("113.8681751844618 "); lats.add("22.577213270399305");
    	lons.add("113.8681898328993 "); lats.add("22.577219780815973");
    	lons.add("113.8682142469618 "); lats.add("22.577226833767362");
    	lons.add("113.86823513454861"); lats.add("22.577234157986112");
    	lons.add("113.8682603624132 "); lats.add("22.577241753472222");
    	lons.add("113.86828667534722"); lats.add("22.577249348958333");
    	lons.add("113.86831624348959"); lats.add("22.577252604166667");
    	lons.add("113.86835069444444"); lats.add("22.57725043402778 ");
    	lons.add("113.86838650173611"); lats.add("22.577250162760418");
    	lons.add("113.86843017578126"); lats.add("22.577249891493057");
    	lons.add("113.86847276475694"); lats.add("22.577249891493057");
    	lons.add("113.86851779513889"); lats.add("22.577245822482638");
    	lons.add("113.8685560438368 "); lats.add("22.57723605685764 ");
    	lons.add("113.86859130859375"); lats.add("22.5772216796875  ");
    	lons.add("113.86861707899305"); lats.add("22.577191297743056");
    	lons.add("113.86865614149306"); lats.add("22.577156846788196");
    	lons.add("113.86871120876737"); lats.add("22.57712646484375 ");
    	lons.add("113.86873426649305"); lats.add("22.577049696180556");
    	lons.add("113.86873969184028"); lats.add("22.576953667534724");
    	lons.add("113.86880615234375"); lats.add("22.576917046440972");
    	lons.add("113.86886420355903"); lats.add("22.576864420572917");
    	lons.add("113.86891710069445"); lats.add("22.576776801215278");
    	lons.add("113.86907606336806"); lats.add("22.576671278211805");
    	lons.add("113.86914388020833"); lats.add("22.57658501519097 ");
    	lons.add("113.86921142578124"); lats.add("22.57651177300347 ");
    	lons.add("113.86929606119791"); lats.add("22.576465657552085");
    	lons.add("113.86936414930555"); lats.add("22.576394585503472");
    	lons.add("113.86944580078125"); lats.add("22.57633273654514 ");
    	lons.add("113.86953043619792"); lats.add("22.576273057725693");
    	lons.add("113.86958713107639"); lats.add("22.57620578342014 ");
    	lons.add("113.86965223524305"); lats.add("22.576163465711804");
    	lons.add("113.86970513237847"); lats.add("22.57610107421875 ");
    	lons.add("113.86977077907986"); lats.add("22.576033799913194");
    	lons.add("113.86981309678819"); lats.add("22.57596652560764 ");
    	lons.add("113.86986870659722"); lats.add("22.575909559461806");
    	lons.add("113.8699085828993 "); lats.add("22.57586697048611 ");
    	lons.add("113.86996744791666"); lats.add("22.57581325954861 ");
    	lons.add("113.87002902560764"); lats.add("22.57578857421875 ");
    	lons.add("113.87007432725694"); lats.add("22.575735134548612");
    	lons.add("113.87011501736112"); lats.add("22.5756787109375  ");
    	lons.add("113.87016194661459"); lats.add("22.575648328993054");
    	lons.add("113.87014078776042"); lats.add("22.575684950086806");
    	lons.add("113.87015109592014"); lats.add("22.57569580078125 ");
    	lons.add("113.87020263671874"); lats.add("22.575723198784722");
    	lons.add("113.87024576822917"); lats.add("22.57565619574653 ");
    	lons.add("113.87020100911458"); lats.add("22.575680881076387");
    	lons.add("113.87020968967013"); lats.add("22.57568359375    ");
    	lons.add("113.87019178602431"); lats.add("22.57568820529514 ");
    	lons.add("113.87017876519097"); lats.add("22.57570583767361 ");
    	lons.add("113.87016927083333"); lats.add("22.57571831597222 ");
    	lons.add("113.87016764322917"); lats.add("22.575727810329862");
    	lons.add("113.87017632378472"); lats.add("22.575726996527777");
    	lons.add("113.87018581814236"); lats.add("22.575721028645834");
    	lons.add("113.87021131727431"); lats.add("22.57571506076389 ");
    	lons.add("113.87024224175347"); lats.add("22.575697157118057");
    	lons.add("113.87028537326388"); lats.add("22.5756640625     ");
    	lons.add("113.87034071180555"); lats.add("22.575601942274307");
    	lons.add("113.87036105685763"); lats.add("22.575537651909723");
    	lons.add("113.87041612413195"); lats.add("22.575499403211804");
    	lons.add("113.87047010633681"); lats.add("22.575474989149306");
    	lons.add("113.87054036458333"); lats.add("22.57544406467014 ");
    	lons.add("113.87055013020833"); lats.add("22.575415581597223");
    	lons.add("113.87056287977431"); lats.add("22.575387098524306");
    	lons.add("113.87059597439236"); lats.add("22.575350748697918");
    	lons.add("113.87062337239583"); lats.add("22.575335286458333");
    	lons.add("113.87059326171875"); lats.add("22.575354817708334");
    	lons.add("113.87060139973958"); lats.add("22.575372178819446");
    	lons.add("113.87061550564236"); lats.add("22.575384657118054");
    	lons.add("113.87062717013889"); lats.add("22.57539089626736 ");
    	lons.add("113.87062771267361"); lats.add("22.57538818359375 ");
    	lons.add("113.87062255859375"); lats.add("22.575375162760416");
    	lons.add("113.87060465494791"); lats.add("22.57536648220486 ");
    	lons.add("113.87060302734375"); lats.add("22.57536349826389 ");
    	lons.add("113.87060465494791"); lats.add("22.575364583333332");
    	lons.add("113.87060845269097"); lats.add("22.57537109375    ");
    	lons.add("113.87060709635416"); lats.add("22.575368923611112");
    	lons.add("113.87061008029514"); lats.add("22.57537163628472 ");
    	lons.add("113.87061252170139"); lats.add("22.57537326388889 ");
    	lons.add("113.87061414930555"); lats.add("22.575377332899304");
    	lons.add("113.8706103515625 "); lats.add("22.57537868923611 ");
    	lons.add("113.87061469184027"); lats.add("22.575381130642363");
    	lons.add("113.870615234375  "); lats.add("22.575380045572917");
    	lons.add("113.87061442057292"); lats.add("22.57537868923611 ");
    	lons.add("113.87061604817708"); lats.add("22.575380316840278");
    	lons.add("113.87061794704861"); lats.add("22.575381944444445");
    	lons.add("113.87062065972222"); lats.add("22.575381673177084");
    	lons.add("113.8706374782986 "); lats.add("22.575386555989585");
    	lons.add("113.87064425998264"); lats.add("22.57539252387153 ");
    	lons.add("113.87065049913194"); lats.add("22.575393880208335");
    	lons.add("113.87064561631945"); lats.add("22.575391438802082");
    	lons.add("113.87064154730903"); lats.add("22.575386827256946");
    	lons.add("113.87064914279514"); lats.add("22.575384928385418");
    	lons.add("113.87067084418403"); lats.add("22.57538601345486 ");
    	lons.add("113.87068929036458"); lats.add("22.57537841796875 ");
    	lons.add("113.87070339626736"); lats.add("22.57536865234375 ");
    	lons.add("113.8707212999132 "); lats.add("22.575359700520835");
    	lons.add("113.8707310655382 "); lats.add("22.57534342447917 ");
    	lons.add("113.87073432074652"); lats.add("22.575321180555555");
    	lons.add("113.87074679904514"); lats.add("22.575306260850695");
    	lons.add("113.87076958550347"); lats.add("22.575294596354166");
    	lons.add("113.87080457899306"); lats.add("22.575277235243057");
    	lons.add("113.87083441840278"); lats.add("22.575262044270833");
    	lons.add("113.87085639105902"); lats.add("22.575250651041667");
    	lons.add("113.87087320963542"); lats.add("22.57524115668403 ");
    	lons.add("113.87087239583333"); lats.add("22.575238986545138");
    	lons.add("113.87087809244791"); lats.add("22.575235460069443");
    	lons.add("113.87087565104167"); lats.add("22.5752294921875  ");
    	lons.add("113.87087456597222"); lats.add("22.575228135850693");
    	lons.add("113.87088975694445"); lats.add("22.575224609375   ");
    	lons.add("113.87090603298611"); lats.add("22.57522976345486 ");
    	lons.add("113.87092312282986"); lats.add("22.575240342881944");
    	lons.add("113.87094618055555"); lats.add("22.575240885416665");
    	lons.add("113.87097601996528"); lats.add("22.57524115668403 ");
    	lons.add("113.87100857204861"); lats.add("22.57521511501736 ");
    	lons.add("113.87103651258681"); lats.add("22.575189887152778");
    	lons.add("113.87107177734374"); lats.add("22.57516357421875 ");
    	lons.add("113.87115234375   "); lats.add("22.57512017144097 ");
    	lons.add("113.87121744791666"); lats.add("22.575106065538193");
    	lons.add("113.87123942057292"); lats.add("22.575036892361112");
    	lons.add("113.87130072699652"); lats.add("22.574994032118056");
    	lons.add("113.87135470920138"); lats.add("22.574957139756943");
    	lons.add("113.87145182291667"); lats.add("22.57488552517361 ");
    	lons.add("113.87151828342014"); lats.add("22.574859754774305");
    	lons.add("113.87155815972223"); lats.add("22.574756673177085");
    	lons.add("113.8716370985243 "); lats.add("22.574698079427083");
    	lons.add("113.87175564236111"); lats.add("22.574641655815974");
    	lons.add("113.87181179470485"); lats.add("22.574574110243056");
    	lons.add("113.87190321180556"); lats.add("22.574521484375   ");
    	lons.add("113.87197319878472"); lats.add("22.574466417100695");
    	lons.add("113.87207139756944"); lats.add("22.574400227864583");
    	lons.add("113.87217176649305"); lats.add("22.574344618055555");
    	lons.add("113.87223253038195"); lats.add("22.574286295572918");
    	lons.add("113.87234130859375"); lats.add("22.57423312717014 ");
    	lons.add("113.87246392144097"); lats.add("22.574165852864585");
    	lons.add("113.87250596788195"); lats.add("22.57401665581597 ");
    	lons.add("113.87260904947917"); lats.add("22.573936631944445");
    	lons.add("113.87273166232639"); lats.add("22.573860677083335");
    	lons.add("113.87285753038195"); lats.add("22.573782552083333");
    	lons.add("113.87296495225695"); lats.add("22.57371826171875 ");
    	lons.add("113.8731654188368 "); lats.add("22.5735205078125  ");
    	lons.add("113.87328640407986"); lats.add("22.57344021267361 ");
    	lons.add("113.87339762369791"); lats.add("22.573368055555555");
    	lons.add("113.87352728949652"); lats.add("22.573289930555557");
    	lons.add("113.87366509331598"); lats.add("22.57321614583333 ");
    	lons.add("113.87376220703125"); lats.add("22.573110080295137");
    	lons.add("113.87388617621528"); lats.add("22.57303168402778 ");
    	lons.add("113.87399224175347"); lats.add("22.572947048611113");
    	lons.add("113.87408962673611"); lats.add("22.57287679036458 ");
    	lons.add("113.87419704861111"); lats.add("22.572837999131945");
    	lons.add("113.87424913194444"); lats.add("22.57279052734375 ");
    	lons.add("113.87429714626737"); lats.add("22.572705891927082");
    	lons.add("113.87435574001736"); lats.add("22.57267279730903 ");
    	lons.add("113.87440538194444"); lats.add("22.572623155381944");
    	lons.add("113.87443901909722"); lats.add("22.572593858506945");
    	lons.add("113.87447482638889"); lats.add("22.57256293402778 ");
    	lons.add("113.8745179578993 "); lats.add("22.57252983940972 ");
    	lons.add("113.87455403645833"); lats.add("22.57251220703125 ");
    	lons.add("113.87462429470486"); lats.add("22.57247585720486 ");
    	lons.add("113.87462049696181"); lats.add("22.572457682291667");
    	lons.add("113.8746603732639 "); lats.add("22.572425401475694");
    	lons.add("113.87470893012153"); lats.add("22.572400987413193");
    	lons.add("113.87478461371528"); lats.add("22.57235297309028 ");
    	lons.add("113.87481906467013"); lats.add("22.572342122395835");
    	lons.add("113.87484347873264"); lats.add("22.57230224609375 ");
    	lons.add("113.87491129557291"); lats.add("22.572262098524305");
    	lons.add("113.87495768229167"); lats.add("22.572215440538194");
    	lons.add("113.87499457465277"); lats.add("22.572198350694446");
    	lons.add("113.87502549913195"); lats.add("22.57217719184028 ");
    	lons.add("113.8750634765625 "); lats.add("22.572154134114584");
    	lons.add("113.87508002387153"); lats.add("22.57213161892361 ");
    	lons.add("113.87512613932292"); lats.add("22.572086046006945");
    	lons.add("113.87516194661458"); lats.add("22.57204047309028 ");
    	lons.add("113.8752086046007 "); lats.add("22.57200954861111 ");
    	lons.add("113.8752476671007 "); lats.add("22.57199001736111 ");
    	lons.add("113.87526611328126"); lats.add("22.57197998046875 ");


    	for(int i=0; i < lons.size(); i++) {	
    	    String url = "http://"+ip+"UploadLocation.do";
    	    String par= "param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'1','longitude':"
    				+lons.get(i).trim()+",'latitude':"+lats.get(i).trim()+ "}}";
    	    String t1 = new DateUtil().getTm();
    	    String ress =MyHttpRequest.sendGet(url, par,"utf-8",false);
    	   // logger.info(ress);
    	    UploadLocationRes res = JSONObject.parseObject(ress,UploadLocationRes.class);
    	    String t2 = new DateUtil().getTm();
    	    if(res == null || res.getBody() == null) continue;
    	    
    	    logger.info("["+i+"]"+"["+res.getBody().getBus_laststa()+"]["+res.getBody().getBus_nextsta()+"]["+res.getBody().getBus_nextdis()+"]"+"["+String.valueOf((Integer.parseInt(t2.substring(4))-Integer.parseInt(t1.substring(4)))/100)+"ms]"+res.getHead().getERRMSG());
    	    //logger.info(res.getBody());
    	    
    	}
    }
    
}