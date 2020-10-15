import discord
from discord.ext import commands


import asyncio
import random
import time
import datetime

import operator
import os
import re

from utils import set_embed, get_date
from const import Docs, Strings
from web_find import SearchWord

class basic_command:
    @staticmethod
    async def command_help(message):
        emb = set_embed(message, title='깔롤랭은 국룰입니다.', description = Docs.help)
        await message.channel.send(embed = emb)

    @staticmethod
    async def command_choice(message):
        chlist = message.content.split()[2:]
        await message.channel.send(f"내가 뽑은건...!\n{random.choice(chlist)}입니당!")
    
    @staticmethod
    async def command_굴러(message):
        await message.channel.send(Strings.roll)
    
    @staticmethod
    async def command_구글검색(message):
        findg = " ".join(message.content.split()[2:])
        image = await SearchWord().get_image(findg)
        em = None
        if image is None:
            await message.channel.send("이미지 불러오기를 실패했습니다")
            return
        else:
            em = set_embed(message, title = f"{findg}의 이미지 검색 결과")
            em.set_image(url = image)
        await message.channel.send(embed = em)
    
    @staticmethod
    async def command_사전검색(message):
        findn = " ".join(message.content.split()[2:])
        findit = await SearchWord().get_dic(findn)

        if findit is None:
            await message.channel.send("사전검색이 실패했습니다.")

        else:
            em = set_embed(message,
                            title = f"{findn}의 네이버 사전검색 결과",
                            description = findit)
            await message.channel.send(embed = em)
    
    @staticmethod
    async def command_급식(message):
        word = message.content.split()[1:]
        meal_list = await SearchWord.get_meal(get_date(message).format_date())
        # meal_list[0] == 조식
        # meal_list[1] == 중식
        # meal_list[2] == 석식

        meal_type = "조식" if "조식" in word or "아침" in word else\
                    "중식" if "중식" in word or "점심" in word else\
                    "석식" if "석식" in word or "저녁" in word or "저녘" in word else "급식"
        # if meal_type is "급식", meal_list[0:3]
        print(meal_list)
        em = set_embed(message, title = f"{meal_type}입니다.")
        try : 
            if meal_type == "급식":
                meal_type_list = ["조식", "중식", "석식"]
                for i in range(0,3):
                    meal = meal_list
                    em.add_field(name = meal_type_list[i], value = meal[i])
        except Exception as e:
            print(e)
        await message.channel.send(embed = em)
        
        

    @staticmethod
    async def command_링크(message):
        await message.channel.send(Docs.url)
        await message.channel.send("여기 있어요,,,")

class custom_command:
    @staticmethod
    async def command_잊어(message, db):#샤키야 key커맨드
        key = message.content.split()[2]
        result = db.command_delete(key)

        if result:
            await message.channel.send("그게,,, 뭐죠,,,?")
        
    
    @staticmethod
    async def command_배워(message : discord.Message, db) :#샤키야 배워 key커맨드 value커맨드
        word = " ".join(message.content.split()[2:]).split(":")
        db.command_insert(word[0], word[1], message.channel.name, message.author.name)
        # key, value, server, user
        
        await message.channel.send("야랄 왜 나한테...")

    

