$(function () {
	//rss json
	var json = {
		rss: {
			channel: {
				title: {
					__cdata: " Najnowsze wiadomości - TVN24 "
				},
				description: {
					__cdata: " Czytaj najnowsze wiadomości z kraju i ze świata oraz oglądaj wideo w portalu TVN24! U nas zawsze najświeższe informacje, unikalne wideo, relacje na żywo. "
				},
				link: "https://tvn24.pl/najnowsze/",
				language: "pl",
				copyright: "TVN",
				lastBuildDate: "2020-11-10T21:09:00.000Z",
				item: [
					{
						title: {
							__cdata: " Eksperci ostrzegają przed promocjami i okazjami. \"Lepiej płacić kartą\" "
						},
						link: "https://tvn24.pl/biznes/z-kraju/black-friday-2020-eksperci-ostrzegaja-przed-promocjami-i-okazjami-w-czarny-piatek-4747737?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/biznes/najnowsze/cdn-zdjecieaaf3c432540bad6f3343d6d7b3249014-zakupy-przez-internet-sa-coraz-popularniejsze-3756293/alternates/LANDSCAPE_1280\" alt=\"Eksperci ostrzegają przed promocjami i okazjami. \"Lepiej płacić kartą\"\" /> Wyjątkowe okazje i specjalne oferty powinny budzić szczególną ostrożność - wskazują eksperci. Radzą też, jak nie dać się oszukać podczas tak zwanego Black Friday, czyli Czarnego Piątku. Gdy nie mamy pewności, czy sklep jest wiarygodny - lepiej zapłacić kartą. To ułatwi ewentualne odzyskanie pieniędzy. "
						},
						pubDate: "2020-11-10T20:43:19.000Z",
						guid: "https://tvn24.pl/biznes/z-kraju/black-friday-2020-eksperci-ostrzegaja-przed-promocjami-i-okazjami-w-czarny-piatek-4747737"
					},
					{
						title: {
							__cdata: " \"Mamy do czynienia z potrójną zdradą\" "
						},
						link: "https://tvn24.pl/polska/kardynal-stanislaw-dziwisz-w-reportazu-don-stanislao-andrzej-zybertowicz-i-pawel-kowal-komentuja-4747445?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-3uza15-10-2000-kropka-cl-x-4747698/alternates/LANDSCAPE_1280\" alt=\"\"Mamy do czynienia z potrójną zdradą\"\" /> Wygląda na to, że kardynał Stanisław Dziwisz zdradził Jana Pawła II, naruszył jego zaufanie - powiedział w \"Kropce nad i\" Andrzej Zybertowicz, doradca prezydenta Andrzeja Dudy. Komentował w ten sposób obraz wieloletniego papieskiego sekretarza, który ukazany został w reportażu \"Don Stanislao. Druga twarz kardynała Dziwisza\". Paweł Kowal, poseł Koalicji Obywatelskiej, ocenił zaś, że \"Jan Paweł II był blokowany, jeśli chodzi o dostęp do informacji\". "
						},
						pubDate: "2020-11-10T19:55:41.000Z",
						guid: "https://tvn24.pl/polska/kardynal-stanislaw-dziwisz-w-reportazu-don-stanislao-andrzej-zybertowicz-i-pawel-kowal-komentuja-4747445"
					},
					{
						title: {
							__cdata: " Które śmieci rozkładają się najdłużej? Pytanie w \"Milionerach\" za 75 tysięcy złotych "
						},
						link: "https://tvn24.pl/ciekawostki/ktore-smieci-rozkladaja-sie-najdluzej-pytanie-w-milionerach-za-75-tysiecy-zlotych-4747623?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-kopx3h-ktore-smieci-rozkladaja-sie-najdluzej-pytanie-w-milionerach-za-75-tysiecy-zlotych-4747622/alternates/LANDSCAPE_1280\" alt=\"Które śmieci rozkładają się najdłużej? Pytanie w \"Milionerach\" za 75 tysięcy złotych\" /> Wszystkie te śmieci rozkładają się kilkaset lat, ale najdłużej: pampers, plastikowa torebka, żyłka wędkarska czy aluminiowa puszka? Na to pytanie za 75 tysięcy złotych odpowiedział Filip Dawidowicz z Łodzi. "
						},
						pubDate: "2020-11-10T19:55:00.000Z",
						guid: "https://tvn24.pl/ciekawostki/ktore-smieci-rozkladaja-sie-najdluzej-pytanie-w-milionerach-za-75-tysiecy-zlotych-4747623"
					},
					{
						title: {
							__cdata: " Pomnik Dzierżyńskiego, opancerzony transporter. Eksponaty trafiają do Muzeum Historii Polski "
						},
						link: "https://tvn24.pl/tvnwarszawa/najnowsze/warszawa-pierwsze-eksponaty-trafiaja-na-wystawe-stala-muzeum-historii-polski-4747680?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/tvnwarszawa/najnowsze/cdn-zdjecie-paegok-pierwsze-eksponaty-trafily-na-wystawe-stala-muzeum-historii-polski-4747687/alternates/LANDSCAPE_1280\" alt=\"Pomnik Dzierżyńskiego, opancerzony transporter. Eksponaty trafiają do Muzeum Historii Polski\" /> Do powstającej siedziby Muzeum Historii Polski na Cytadeli dostarczono pierwsze wielkogabarytowe eksponaty. A wśród nich obalony w 1989 roku pomnik Feliksa Dzierżyńskiego z placu Bankowego, transporter opancerzony widywany na ulicach podczas stanu wojennego, fragmenty ponad tysiącletniego dębu. "
						},
						pubDate: "2020-11-10T19:47:50.000Z",
						guid: "https://tvn24.pl/tvnwarszawa/najnowsze/warszawa-pierwsze-eksponaty-trafiaja-na-wystawe-stala-muzeum-historii-polski-4747680"
					},
					{
						title: {
							__cdata: " Isakowicz-Zaleski: Są dwa wyjścia. Komisja powołana przez samego papieża albo na wzór francuski  "
						},
						link: "https://tvn24.pl/polska/stanislaw-dziwisz-bohaterem-reportazu-don-stanislao-druga-twarz-kardynala-dziwisza-ksiadz-tadeusz-isakowicz-zaleski-ojciec-pawel-guzynski-i-zuzanna-radzik-komentuja-4747443?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-pqaih1-fpf-4747677/alternates/LANDSCAPE_1280\" alt=\"Isakowicz-Zaleski: Są dwa wyjścia. Komisja powołana przez samego papieża albo na wzór francuski \" /> Osoba księdza kardynała Dziwisza jest bardzo ważna dla historii Kościoła, także dla pamięci o Janie Pawle II i na pewno jest wiele pozytywów w tej postaci. Dlatego papież Franciszek powinien sam powołać odpowiednią komisję - mówił w \"Faktach po Faktach\" w TVN24 ksiądz Tadeusz Isakowicz-Zaleski, który występuje w reportażu Marcina Gutowskiego \"Don Stanislao. Druga twarz kardynała Dziwisza\". Odniósł się w ten sposób, do zarzutów, jakie padają pod adresem byłego papieskiego sekretarza. - Musimy całkowicie zmienić strukturę władzy kościelnej - dodał dominikanin, ojciec Paweł Gużyński.  "
						},
						pubDate: "2020-11-10T19:45:31.000Z",
						guid: "https://tvn24.pl/polska/stanislaw-dziwisz-bohaterem-reportazu-don-stanislao-druga-twarz-kardynala-dziwisza-ksiadz-tadeusz-isakowicz-zaleski-ojciec-pawel-guzynski-i-zuzanna-radzik-komentuja-4747443"
					},
					{
						title: {
							__cdata: " PGNiG ma nowego prezesa "
						},
						link: "https://tvn24.pl/biznes/z-kraju/pawel-majewski-to-nowy-prezes-pgnig-odchodzi-z-grupy-lotos-4747648?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-4glcfe-pawel-majewski-4747654/alternates/LANDSCAPE_1280\" alt=\"PGNiG ma nowego prezesa\" /> Paweł Majewski został we wtorek powołany na prezesa zarządu Polskiego Górnictwa Naftowego i Gazownictwa - podała w komunikacie spółka. Majewski opuszcza stanowisko prezesa w Grupie Lotos. Na czele nowej firmy ma stanąć 12 listopada. "
						},
						pubDate: "2020-11-10T19:11:16.000Z",
						guid: "https://tvn24.pl/biznes/z-kraju/pawel-majewski-to-nowy-prezes-pgnig-odchodzi-z-grupy-lotos-4747648"
					},
					{
						title: {
							__cdata: " Liczba zakażeń a \"narodowa kwarantanna\". Które województwa przekroczyły próg wskazany przez rząd? "
						},
						link: "https://tvn24.pl/polska/koronawirus-w-polsce-narodowa-kwarantanna-wojewodztwa-ktore-przekroczyly-granice-70-zakazen-na-100-tys-4747633?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-vkxf74-wykres-4747638/alternates/LANDSCAPE_1280\" alt=\"Liczba zakażeń a \"narodowa kwarantanna\". Które województwa przekroczyły próg wskazany przez rząd?\" /> W ciągu ostatnich siedmiu dni, między 4 a 10 listopada, w całej Polsce odnotowano średnio 66,54 infekcji na 100 tysięcy mieszkańców. Oznacza to, że jesteśmy bardzo blisko granicy, której przekroczenie może oznaczać wprowadzenie \"narodowej kwarantanny\". Jak wygląda sytuacja w poszczególnych województwach? "
						},
						pubDate: "2020-11-10T18:48:19.000Z",
						guid: "https://tvn24.pl/polska/koronawirus-w-polsce-narodowa-kwarantanna-wojewodztwa-ktore-przekroczyly-granice-70-zakazen-na-100-tys-4747633"
					},
					{
						title: {
							__cdata: " Stonowany optymizm na rynkach. Złoty słabnie "
						},
						link: "https://tvn24.pl/biznes/rynki/notowania-zlotego-kurs-euro-dolara-franka-i-funta-10-listopada-2020-4747626?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-gzd3cs-pieniadze-pln-kasa-zloty-s-shutterstock1461330125jpg/alternates/LANDSCAPE_1280\" alt=\"Stonowany optymizm na rynkach. Złoty słabnie\" /> Wciąż widać optymizm na rynkach - nie jest on jednak tak duży jak w poniedziałek i złoty osłabia się. W środę z powodu Święta Niepodległości na rynku zabraknie krajowych inwestorów i w związku z tym złoty może jeszcze bardziej tracić na wartości - oceniła główna ekonomistka Banku Pocztowego Monika Kurtek. "
						},
						pubDate: "2020-11-10T18:40:56.000Z",
						guid: "https://tvn24.pl/biznes/rynki/notowania-zlotego-kurs-euro-dolara-franka-i-funta-10-listopada-2020-4747626"
					},
					{
						title: {
							__cdata: " Wypadek na Popularnej. Potrącona kobieta, auto wpadło w ogrodzenie "
						},
						link: "https://tvn24.pl/tvnwarszawa/ulice/warszawa-wlochy-wypadek-na-popularnej-4747615?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/tvnwarszawa/najnowsze/cdn-zdjecie-50voi6-do-zdarzenia-doszlo-w-alejach-jerozolimskich-4747600/alternates/LANDSCAPE_1280\" alt=\"Wypadek na Popularnej. Potrącona kobieta, auto wpadło w ogrodzenie\" /> Wieczorny wypadek na ulicy Popularnej. Jak informuje policja, kierowca auta potrącił kobietę. Z informacji naszego reportera wynika, że prowadzący samochód stracił panowanie nad kierownicą. "
						},
						pubDate: "2020-11-10T18:06:51.000Z",
						guid: "https://tvn24.pl/tvnwarszawa/ulice/warszawa-wlochy-wypadek-na-popularnej-4747615"
					},
					{
						title: {
							__cdata: " Terlikowski: Kardynał obudził się w świecie, w którym to dobro ofiary jest kluczowe. I on naprawdę tego nie rozumie "
						},
						link: "https://tvn24.pl/polska/kardynal-stanislaw-dziwisz-w-reportazu-don-stanislao-tomasz-terlikowskii-ks-andrzej-kobylinski-komentuja-4747516?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-geunlz-10-1800-tak-jest-cl-x-4747620/alternates/LANDSCAPE_1280\" alt=\"Terlikowski: Kardynał obudził się w świecie, w którym to dobro ofiary jest kluczowe. I on naprawdę tego nie rozumie\" /> Istniało przekonanie, że wyrazem troski o Kościół jest tuszowanie takich spraw, jest ukrywanie ich - powiedział w \"Tak jest\" publicysta Tomasz Terlikowski, komentując reportaż \"Don Stanislao. Druga twarz kardynała Dziwisza\". Ksiądz Andrzej Kobyliński z Uniwersytetu Kardynała Stefana Wyszyńskiego ocenił zaś, że \"mamy do czynienia tak naprawdę z konieczną, głęboką reformą Kościoła katolickiego\". "
						},
						pubDate: "2020-11-10T18:05:25.000Z",
						guid: "https://tvn24.pl/polska/kardynal-stanislaw-dziwisz-w-reportazu-don-stanislao-tomasz-terlikowskii-ks-andrzej-kobylinski-komentuja-4747516"
					},
					{
						title: {
							__cdata: " Listy, awanse i pieniądze. Co wiemy o relacjach kardynała Dziwisza z McCarrickiem? "
						},
						link: "https://tvn24.pl/polska/kardynal-stanislaw-dziwisz-a-theodore-mccarrick-raport-watykanu-i-reportaz-don-stanislao-drugie-oblicze-kardynala-dziwisza-4747536?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-vdsalo-kardynal-dziwisz-a-theodore-mccarrick-4747541/alternates/LANDSCAPE_1280\" alt=\"Listy, awanse i pieniądze. Co wiemy o relacjach kardynała Dziwisza z McCarrickiem?\" /> Najpierw reportaż TVN24, a następnego dnia obszerny raport Stolicy Apostolskiej. Oba ukazują zależności między kardynałem Stanisławem Dziwiszem a Theodorem McCarrickiem, który za nadużycia seksualne został wydalony ze stanu kapłańskiego. Dokument Watykanu koncentruje się przede wszystkim na wpływie byłego papieskiego sekretarza na kolejne kościelne nominacje dla Amerykanina, materiał Marcina Gutowskiego stawia również pytania o ich wzajemne powiązania finansowe. Co wiemy o relacjach kardynała Dziwisza z McCarrickiem? "
						},
						pubDate: "2020-11-10T17:54:43.000Z",
						guid: "https://tvn24.pl/polska/kardynal-stanislaw-dziwisz-a-theodore-mccarrick-raport-watykanu-i-reportaz-don-stanislao-drugie-oblicze-kardynala-dziwisza-4747536"
					},
					{
						title: {
							__cdata: " \"Takie wypowiedzi są kompromitujące dla rządu\". Opozycja o słowach wiceministra finansów "
						},
						link: "https://tvn24.pl/biznes/z-kraju/opozycja-krytykuje-slowa-wiceministra-finansow-piotra-patkowskiego-o-konsumentach-4747561?source=rss",
						description: {
							__cdata: " <img src=\"https://tvn24.pl/najnowsze/cdn-zdjecie-f47e30-patkowski-4747528/alternates/LANDSCAPE_1280\" alt=\"\"Takie wypowiedzi są kompromitujące dla rządu\". Opozycja o słowach wiceministra finansów\" /> Ta wypowiedź dyskwalifikuje go z funkcji, którą pełni - stwierdziła posłanka Lewicy Joanna Scheuring-Wielgus. - To jest dramat, że tacy ludzie odpowiadają za finanse państwa - dodał Dariusz Joński, poseł Koalicji Obywatelskiej. W ten sposób politycy opozycji komentowali wypowiedź wiceministra finansów Piotra Patkowskiego, który ocenił, że konsumenci nie odczuli bezpośrednio w swoich kieszeniach skutków epidemii. "
						},
						pubDate: "2020-11-10T17:38:52.000Z",
						guid: "https://tvn24.pl/biznes/z-kraju/opozycja-krytykuje-slowa-wiceministra-finansow-piotra-patkowskiego-o-konsumentach-4747561"
					}
				]
			},
			_xmlnsatom: "http://www.w3.org/2005/Atom",
			_version: "2.0"
		}
	}
	//remove unwanted news from json
	var itemslist = json.rss.channel.item.slice(0, 5)
	json.rss.channel.item = itemslist

	for (item of itemslist){
		item.description.__cdata = item.description.__cdata.replace(/<img.+>/g, '')
	}

	//mustache template
	var template = `<ul> {{#rss.channel.item }}  
						<li>	
							{{title.__cdata}} <br>
							<a href="{{link}}"> Link <br> </a>
							{{description.__cdata}}
							<br><br><br>
						</li>
					{{/rss.channel.item }} </ul>`

	function renderNews(json, template) {
		var rendered = Mustache.render(template, json);
		$('#target').html(rendered)
	}
	renderNews(json, template)
})
