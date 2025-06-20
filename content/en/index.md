---
title: Home
description: sake.ba is a personal website belonging to Sakib Hadžiavdić
---

# Hello World! 🌍

Hi! I am Sakib. 🙋‍♂️  
Welcome to my personal website.


## Writing
- book [Learn Programming with FlowRun](https://a.co/d/bVxMBe4) for beginner programmers
- [blog](https://blog.sake.ba/en) mostly about programming
- [notes](https://github.com/sake92/notes)


## Open Source Software
{%
set projects = [
    { "label": "FlowRun", "link": "https://flowrun.io/", "desc": "runnable flowcharts for web" },
    { "label": "Sharaf", "link": "https://sake92.github.io/sharaf/", "desc": "Minimalistic Scala 3 web framework" },
    { "label": "Hepek", "link": "https://github.com/sake92/hepek", "desc": "static site generator" },
    { "label": "OpenApi4s", "link": "https://github.com/sake92/openapi4s", "desc": "OpenApi generators for Scala" },
    { "label": "nand2tetris solutions", "link": "https://github.com/sake92/nand2tetris", "desc": "CPU, assembler, VM, and a Programming Language implementation" }
]
%}

{% for project in projects %}
- [{{ project.label }}]({{ project.link }}) - {{ project.desc }}

{% endfor %}


## Talks

[Project Amber](https://sake.ba/presentations/2020-09-09%20Amber%20-%20JUGBA),
[Writing an Interpreter](https://sake.ba/presentations/2020-01-07%20Writing%20an%20interpreter%20-%20OpenWeb%20Sarajevo),
[Open Source](https://sake.ba/presentations/2018-10-27%20OpenSource%20-%20Hacktoberfest%20Sarajevo),
[FP Intro](https://sake.ba/presentations/2018-09-08%20FP%20intro%20-%20freeCodeCamp%20Sarajevo),
[Hepek](https://sake.ba/presentations/2018-08-28%20Hepek%20-%20OpenWeb%20Sarajevo),
[Scala Intro](https://sake.ba/presentations/2018-01-23%20Scala%20intro%20-%20OpenWeb%20Sarajevo)


## About

[github](https://github.com/sake92),
[stackoverflow](https://stackoverflow.com/users/4496364/insan-e),
[linkedin](https://www.linkedin.com/in/sakib-hadziavdic)


## Legal

I have my sole proprietorship company [SaCode](https://sacode.dev/).
