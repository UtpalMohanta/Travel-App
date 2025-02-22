package com.example.travelapp.akash

@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel){



    var username = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    var email = remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Bapp)){

        Column(modifier = Modifier.fillMaxSize()) {

            Image(painter = painterResource(id = R.drawable.logo_project),
                contentDescription = "logo",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .size(200.dp)
                ,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 15.dp, end = 15.dp,
                )
                .clip(shape = RoundedCornerShape(corner = CornerSize(20.dp))),

                elevation = CardDefaults.cardElevation(10.dp),

                ) {


                Surface(modifier = Modifier.fillMaxWidth(),
                    color = Color.White) {


                    Column(modifier = Modifier) {

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "WelCome",
                            style = TextStyle(
                                color = Pink80,
                                fontWeight = FontWeight.ExtraBold,
                                fontStyle = FontStyle.Italic,
                                fontSize = 32.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        inputField(
                            label = "Username", value = username.value,
                            onValueChange = { username.value = it },
                            imageVector = Icons.Default.Person,
                        )
                        //Spacer(modifier = Modifier.width(40.dp))
                        inputField(label = "Email", value = email.value,
                            onValueChange = { email.value = it },
                            imageVector = Icons.Default.Email)
                        //Spacer(modifier = Modifier.width(40.dp))
                        inputField(
                            label = "Password", value = password.value,
                            onValueChange = { password.value = it },
                            imageVector = Icons.Default.Lock
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        button(btnTxt = "LOGIN", navController = navController)
                        Spacer(modifier = Modifier.height(20.dp))





                    }




                }



            }

            Spacer(modifier = Modifier.height(40.dp))


            TextButton(onClick = {
                navController.navigate("SignupPage")

            }) {
                Text(
                    text = "Don't have an account? Register",
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.fillMaxWidth()

                )


            }





        }


    }



}