package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        // features file larimizin oldugu dosyalarin path i
        glue = "step_definitions",
        // features file larimizi test edebilmemiz icin gerekli methodlarin store edildigi step definitions klasorunun pathi
        tags = "@SmokeTest",
        // test case lerimiz arasinda taglerle yaptigimiz siniflandirmalari runner classa cagiracagimiz tagler.
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"json:target/report.json", "rerun:target/rerun.txt"},
        // json:target/report.json --> json: = plugin, target = raporun kaydedilmesini istedigim klasor(istedigim
        // baska bir paket altina da bu klasoru store edebilirim, target olmak zorunda degil), report = raporun
        // kaydedilmesini istedigim dosya ismi(istedigim herhangi bir ismi dosya ismi olarak verebilirim, report demek
        // zorunda degilim, myreport, myfavoritereport vs istedigim sekilde adlandirabilirim), .json = kaydettigim rapor
        // dosyasinin uzantisi. Bu plugin kullanildiginda bu runner class icindeki run ettigimiz butun testler ile
        // ilgili ayrintili raporlar aliyoruz. testin ne kadar surede yapildigi, hangi test tagleri test edildiyse
        // onlarin icinden hangilerinin pass hangilerinin fail oldugunu gosteren, fail olan testler icin ayri, pass olan
        // testler icin ayri ayrintili raporlarin olusturuldugu bir plugin. Bu plugin projeye eklendiginde
        // cucumber-sandwich jar dosyasinin projeye eklenmesi ile birlikte gelen cucumber-html-report dosyasi altindaki
        // seceneklerden hangi raporu almak, goz atmak istedigimizi secebiliyoruz. bu runner class icinde tag ledigimiz
        // testlerin arasinda failed olan testler oldugunda bu testleri fix ettikten sonra tekrar runner classi run
        // ettigimizde target klasoru icinde actigimiz report.json dosyasi otomatik olarak guncellenirken,
        // cucumber-html-report klasoru altindaki raporlarin guncellenmesi icin ayrica
        // "java -jar src/test/resources/techtorial-cucumber-sandwich.jar -n -f . -o ." tekrar terminalde calistirilmasi
        // gerekiyor. Bu satir calistirildiginda failed olan testlerin fix edildikten sonraki guncel raporlara ayrintili
        // sekilde yine ulasabilmemiz gerekiyor.

        // rerun: = runner class icindeki sectigimiz tagler icindeki testlerden failed olanlari tekrar tek baslarina
        // test etmek icin kullanilan plugin. Bu plugin ornegin 500 tane regression testi icerisinden 2 tanesi failed
        // oldu ve biz sadece o iki testi tekrar run etmek istiyoruz. Bu gibi durumlarda bastan sona tekrar 500 test
        // case i run etmek yerine failed olanlar fix edildikten sonra calisiyor mu calismiyor mu bunu kontrol etmek
        // icin sadece failed olanlari test etmemize olanak taniyan plugin. target = rerun pluginini store etmek
        // istedigimiz klasor ismi. Bu target folder altinda olmak zorunda degil, baska herhangi bir yerde de klasor
        // olusturarak onun altina store edebiliriz. rerun.txt = rerun edilecek failed olmus testlerimizi listeleyecek
        // dosyanin adi ve uzantisi. txt dosyasi olusturup hangi scenario icindeki hangi step de sorun varsa o step i
        // listeleyecek ve biz de rahatlikla 500 tane test case in arasindan hangi stepte sorun oldugunu buradan gorup
        // gidip onu fix edecegiz.
        dryRun = false // false olmasi demek olmamasi demekle ayni. eger olmazsa .feature file daki scenario steplerinin arasinda implement edilmis olan var mi yok mu arastirma yapmak icin bastan sona hepsini geziyor ama eger true olursa o zaman sadece implement edilmemis olanlari aliyr.
)

public class Runner {

}
