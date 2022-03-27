# mutantes-gateway
Microservice responsable por registrar cadenas de ADN en la base de datos

## Dependencias
[mutantes-registry](https://github.com/arthurmessias/mutantes-registry) - NetFlix Eureka Server

## Para clonar este repositorio
```bash
git clone https://github.com/arthurmessias/mutantes-gateway.git
cd mutantes-gateway
```

## Unit tests
No aplica

## Start API-Gateway
```bash
mvn spring-boot:run
```

## mutantes-gateway routes
* Local endpoint: http://localhost:8765
* Heroku endpoint: https://mutantes-gateway.herokuapp.com

### POST /statistic
```
http://localhost:8765/mutantes-db/statistic?version=1
```

**Parameters**
`version=1`

**Body**
`application/json`
```
{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"],
	"isMutant": true;
}
```

**Response**
`application/json` `201-CREATED`
```
{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"],
	"isMutant": true;
}
```

### GET /stats
```
http://localhost:8765/mutantes-db/stats?version=1
```

**Parameters**
`version=1`

**Response**
`application/json` `200-OK`
```
{
	"count_mutant_dna":40, 
	"count_human_dna":100: 
	"ratio":0.4
}
```

### POST /mutant
```
http://localhost:8765/mutantes/mutant?version=1
```
___
#### Mutante
**Parameters**
`version=1`

**Body**
`application/json`
```
{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```

**Response**
`text/plain;charset=UTF-8` `200-OK`
```
Mutant
```
___

#### No-Mutante
**Parameters**
`version=1`

**Body**
`application/json`
```
{
    "dna":["AGAATT","CGCCTT","TTATTT","AGACGG","GCGTCA","TCACTG"]
}
```

**Response**
`application/json` `403-Forbidden`
```
{
    "timestamp": "2022-03-26T00:38:08.208+00:00",
    "message": "No-Mutante",
    "details": "uri=/mutantes-api/mutant"
}
```
