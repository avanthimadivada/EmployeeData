package com.example.empdata;

import org.springframework.data.annotation.Id;

record Employee (@Id Integer id, String name){

}
