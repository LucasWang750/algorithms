import turtle

wn = turtle.Screen()
wn.title('Pong')
wn.setup(width=800, height=600)
wn.bgcolor('black')
wn.tracer(0)

score_a = 0
score_b = 0

def make_turtle(turtle_name, stretch_wid, stretch_len, posX, posY):
    turtle_name.speed(0)
    turtle_name.shape("square")
    turtle_name.color("white")
    turtle_name.shapesize(stretch_wid, stretch_len)
    turtle_name.penup()
    turtle_name.goto(posX, posY)

def paddle_a_up():
    y = paddle_a.ycor()
    if y < 240:
        y += 20
    paddle_a.sety(y)

def paddle_a_down():
    y = paddle_a.ycor()
    if y > -225:
        y -= 20
    paddle_a.sety(y)

def paddle_b_up():
    y = paddle_b.ycor()
    if y < 240:
        y += 20
    paddle_b.sety(y)

def paddle_b_down():
    y = paddle_b.ycor()
    if y > -225:
        y -= 20
    paddle_b.sety(y)

#left paddle
paddle_a = turtle.Turtle()
make_turtle(paddle_a, 5, 1, -350, 0)

#right paddle
paddle_b = turtle.Turtle()
make_turtle(paddle_b, 5, 1, 350, 0)

#ball
ball = turtle.Turtle()
make_turtle(ball, 1, 1, 0, 0)
ball.shape('circle')
ball.dx = 5
ball.dy = 10

#score
score = turtle.Turtle()
score.hideturtle()
make_turtle(score, 1, 1, 0, 260)
score.write('Player 1: 0 Player 2: 0', align="center", font=("Courier", 24, "normal"))


wn.listen()
wn.onkeypress(paddle_a_up, "w")
wn.onkeypress(paddle_a_down, "s")
wn.onkeypress(paddle_b_up, "Up")
wn.onkeypress(paddle_b_down, "Down")


while True:
    wn.update()

    # Move the ball
    ball.setx(ball.xcor() + ball.dx)
    ball.sety(ball.ycor() + ball.dy)

    # Border checking

    # Top and bottom
    if ball.ycor() > 290:
        ball.sety(290)
        ball.dy *= -1
    elif ball.ycor() < -290:
        ball.sety(-290)
        ball.dy *= -1

    # Left and right
    if ball.xcor() > 350:
        score_a += 1
        score.clear()
        score.write("Player A: {}  Player B: {}".format(score_a, score_b), align="center", font=("Courier", 24, "normal"))
        ball.goto(0, 0)
        ball.dx *= -1
    elif ball.xcor() < -350:
        score_b += 1
        score.clear()
        score.write("Player A: {}  Player B: {}".format(score_a, score_b), align="center", font=("Courier", 24, "normal"))
        ball.goto(0, 0)
        ball.dx *= -1

    # Paddle and ball collisions
    if ball.xcor() < -340 and ball.ycor() < paddle_a.ycor() + 50 and ball.ycor() > paddle_a.ycor() - 50:
        ball.dx *= -1

    elif ball.xcor() > 340 and ball.ycor() < paddle_b.ycor() + 50 and ball.ycor() > paddle_b.ycor() - 50:
        ball.dx *= -1


