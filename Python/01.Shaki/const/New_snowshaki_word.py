import random

class Strings:
    emoji = random.choice(["야발","어쩌라고요,,,,","☆*:.｡. o(≧▽≦)o .｡.:*☆","༼ ༎ຶ ෴ ༎ຶ༽","༼; ́༎ຶ ۝༎ຶ`༽","༼; ́༎ຶ + ༎ຶ༽]","(╬ ಠ 益ಠ)","ಥಒ್ಲಥ","ꂧ᷆◞८̯◟ꂧ᷆","૮(ꂧꁞꂧ)ა","(๑≖ิټ≖ิ)","(´⊙ω⊙`)","( ́◞ิ౪◟ิ‵)","ᓀ( ́◒`๑)","(ง ̇∇ ̇)ว(ว ̇∇ ̇)ง"])
    roll = random.choice(["데구르르 꽝","꽝 데구르르","데구르르 뎅강","ㄷㄱㄹㄹ ㄷㄱ","야랄,,, 너나 구르세요"])
    command_prefixes = {
        'help' : ["도움말","명령어","help","?","도와줘"],
        'choice' : ["골라","뽑아","chose"],
        '배워' : ["배워","익혀","study"],
        '잊어' : ['잊어',"forget"],
        '구글검색' : ['구글검색','사진검색','사진가져와', '사진'],
        '사전검색' : ['사전검색','지식검색','네이버검색', '사전'],
        '굴러' : ["구르기","앞구르기","뒷구르기","데굴데굴","굴러","뒹굴뒹굴","rnffj","eprnfmfm","Rhkd"],
        '닉네임' : ["이름","구분"],
        'custom' : ["커스텀","커맨드","사용자지정"],
        'study' : ["공부","스터디","study","learning"],
        'Hello' : ["Hello",'hello','안녕','ㅎㅇ','하이','깔롤랭'],
        '급식' : ['급식','밥','배고파', '조식', '아침', '중식', '점심', '석식', '저녁', '저녘'],
        '링크' : ['url','Url', 'URL', '링크', '주소', '초대']
    }
    commands = {
        'help' : ["샤키명령어","샤키도움말"]
    }
    custom = [
        '배워',
        '잊어'
    ]
    meal_dict = {
        "조식" : 0,
        "중식" : 1,
        "석식" : 2
    }
    week = [
        "일",
        "월",
        "화",
        "수",
        "목",
        "금",
        "토"
    ]
    dateCentury = [
        "하룻",
        "이튿",
        "사흗",
        "나흗",
        "닷샛",
        "엿샛",
        "이렛",
        "여드렛",
        "아흐렛"
    ]
    dateCenturyAbbr = [
        "하루",
        "이틀",
        "사흘",
        "나흘",
        "닷새",
        "엿새",
        "이레",
        "여드레",
        "아흐레"
    ]
    dateExp = [
        "그끄저께",
        "그끄제",
        "그저께",
        "그제",
        "어제",
        "오늘",
        "내일",
        "모레",
        "글피",
        "그글피"
    ]
    dateYearExp = [
        "재재작년",
        "재작년",
        "작년",
        "올해",
        "내년",
        "후년",
        "내후년",
        "후후년"
    ]
