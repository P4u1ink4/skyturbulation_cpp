#include <SFML/Audio.hpp>
#include <SFML/Graphics.hpp>
#include <iostream>
#include <math.h>
#include "ResourcePath.hpp"

const int W=503;
const int H=667;
sf::RenderWindow window(sf::VideoMode(W,H), "Sky Turbulation");

class entity{
    private:
        std::string name;
public:
    virtual void setName(std::string name2){
        name = name2;
    }
    virtual void draw()
   {
        std::cout<<"just check"<<std::endl;
   }
};

class rocks: public entity
{
   private:
     bool life=true;
     bool cancollide=true;
     std::string name;
   public:
    float x=0.f,y=0.f;
    sf::FloatRect boundingBox;
    
   rocks()
   {
       setName();
   }
    
    void setName(){
        name = "rock";
    }
    
    void setLife(bool iflife){
        life = iflife;
    }
    void setCancollide(bool ifcollide){
        cancollide = ifcollide;
    }
    bool getLife(){
        return life;
    }
    bool getCollide(){
        return cancollide;
    }
    
    void draw()
   {
        sf::Texture texture;
        if (!texture.loadFromFile(resourcePath() + "rock.png")) {
            return EXIT_FAILURE;
        }
        if(getLife()==true){
            setCancollide(true);
            sf::Sprite sprite(texture);
            sprite.setPosition(x,y);
            boundingBox = sprite.getGlobalBounds();
            window.draw(sprite);
        }
   }

};

class player: public entity
{
   public:
    float x=200.f,y=400.f;
    sf::FloatRect boundingBox;
    std::string name;
    
   player()
   {
     setName();
   }
    
    void setName(){
        name = "player";
    }
    
    
    void draw()
   {
        sf::Texture texture;
        if (!texture.loadFromFile(resourcePath() + "racket.png")) {
            return EXIT_FAILURE;
        }
        sf::Sprite sprite(texture);
        sprite.setPosition(x,y);
        boundingBox = sprite.getGlobalBounds();
        window.draw(sprite);
   }

};

void DRAW(entity &entity){ entity.draw(); }
        
bool collision(player racket, rocks rock)
{
    if(racket.boundingBox.intersects(rock.boundingBox) && rock.getCollide())
    {
        return true;
    }
    else return false;
}

int main(int, char const**)
{
    int wait=500;
    bool start=false;
    int points=0;
    int lifes=3;
    
    sf::Image icon;
    if (!icon.loadFromFile(resourcePath() + "icon.png")) {
        return EXIT_FAILURE;
    }
    window.setIcon(icon.getSize().x, icon.getSize().y, icon.getPixelsPtr());
    
    sf::Texture texture,texture4;
    if (!texture.loadFromFile(resourcePath() + "sky.jpeg")) {
        return EXIT_FAILURE;
    }
    if (!texture4.loadFromFile(resourcePath() + "heart.png")) {
        return EXIT_FAILURE;
    }
    sf::Sprite sprite(texture);
    sf::Sprite heart1(texture4);
    sf::Sprite heart2(texture4);
    sf::Sprite heart3(texture4);
    heart1.setPosition(430.f, -10.f);
    heart2.setPosition(410.f, -10.f);
    heart3.setPosition(390.f, -10.f);
    
    sf::Font font;
    if (!font.loadFromFile(resourcePath() + "font.ttf")) {
        return EXIT_FAILURE;
    }
    sf::Text text,text2,text3;
    text.setFont(font);
    text.setString("GAME OVER");
    text.setCharacterSize(50);
    text.setFillColor(sf::Color::White);
    text.setPosition(130.f, 400.f);
    
    text2.setFont(font);
    text2.setString("PRESS 'S' TO START");
    text2.setCharacterSize(45);
    text2.setFillColor(sf::Color::White);
    
    text3.setFont(font);
    text3.setCharacterSize(100);
    text3.setPosition(150.f, 0);
    text3.setFillColor(sf::Color::White);
   
    player racket = *new player();
    
    rocks rock = *new rocks();
    rocks rock2 = *new rocks();
    rocks rock3 = *new rocks();
    rocks rock4 = *new rocks();
    rocks rock5 = *new rocks();
    
    rock2.x=80.f;
    rock3.x=180.f;
    rock4.x=280.f;
    rock5.x=380.f;
    
    while (window.isOpen())
    {
        sf::Event event;
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed) {
                window.close();
            }
            if (event.type == sf::Event::KeyPressed && event.key.code == sf::Keyboard::Escape) {
                window.close();
            }

        }
        if(start==false){
            window.draw(sprite);
            window.draw(text2);
            window.display();
        }
        if(sf::Keyboard::isKeyPressed(sf::Keyboard::S)) {
            start=true;
        }
        if(start==true){
            if(collision(racket,rock) && wait==0 && lifes>0){
                rock.setLife(false);
                rock.setCancollide(false);
                lifes-=1;
                wait=1000;
                if(lifes==0){
                    text3.setString(std::to_string(points));
                 }
            }
            if(collision(racket,rock2) && wait==0 && lifes>0){
                rock2.setLife(false);
                rock2.setCancollide(false);
                lifes-=1;
                wait=1000;
                if(lifes==0){
                    text3.setString(std::to_string(points));
                 }
            }
            if(collision(racket,rock3) && wait==0 && lifes>0){
                rock3.setLife(false);
                rock3.setCancollide(false);
                lifes-=1;
                wait=1000;
                if(lifes==0){
                    text3.setString(std::to_string(points));
                 }
            }
            if(collision(racket,rock4) && wait==0 && lifes>0){
                rock4.setLife(false);
                rock4.setCancollide(false);
                lifes-=1;
                wait=1000;
                if(lifes==0){
                    text3.setString(std::to_string(points));
                 }
            }
            if(collision(racket,rock5) && wait==0 && lifes>0){
                rock5.setLife(false);
                rock5.setCancollide(false);
                lifes-=1;
                wait=1000;
                if(lifes==0){
                    text3.setString(std::to_string(points));
                 }
            }
            
            if(wait>0){ wait--; }
            
            if(rock.y>600.f){
                points++;
                rock.y=0;
                rock.setLife(true);
                rock.x=rand()%W;
            }
            else rock.y+=0.70;
            
            if(rock2.y>600.f){
                points++;
                rock2.y=0;
                rock2.setLife(true);
                rock2.x=rand()%W;
            }
            else rock2.y+=0.40;
            
            if(rock3.y>600.f){
                points++;
                rock3.y=0;
                rock3.setLife(true);
                rock3.x=rand()%W;
            }
            else rock3.y+=0.50;
            
            if(rock4.y>600.f){
                points++;
                rock4.y=0;
                rock4.setLife(true);
                rock4.x=rand()%W;
            }
            else rock4.y+=0.30;
            
            if(rock5.y>600.f){
                points++;
                rock5.y=0;
                rock5.setLife(true);
                rock5.x=rand()%W;
            }
            else rock5.y+=0.55;
            
            if(sf::Keyboard::isKeyPressed(sf::Keyboard::Right)) {
                if(racket.x<450.f) racket.x+=0.5;
            }
            if(sf::Keyboard::isKeyPressed(sf::Keyboard::Left)){
                if(racket.x>-30.f) racket.x-=0.5;
            }
            if(sf::Keyboard::isKeyPressed(sf::Keyboard::Up)){
                if(racket.y>-80.f) racket.y-=0.5;
            }
            if(sf::Keyboard::isKeyPressed(sf::Keyboard::Down)){
                if(racket.y<600.f) racket.y+=0.5;
            }

           window.draw(sprite);
           if(lifes==3){
               window.draw(heart1);
               window.draw(heart2);
               window.draw(heart3);
           }
           if(lifes==2){
               window.draw(heart1);
               window.draw(heart2);
           }
           if(lifes==1){
               window.draw(heart1);
           }
            if(lifes>0){
                DRAW(rock);
                DRAW(rock2);
                DRAW(rock3);
                DRAW(rock4);
                DRAW(rock5);
            }
           if(lifes>0 && wait>400 && wait%2==0){
               DRAW(racket);
           }
           else if(lifes>0 && wait<400){
             racket.draw();
           }
           if(lifes==0){
               window.draw(text);
               window.draw(text3);
            }
           window.display();
        }
    }
    return EXIT_SUCCESS;
}
