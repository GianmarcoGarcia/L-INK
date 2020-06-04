const app = document.getElementById('root')

const logo = document.createElement('img')
logo.src = 'logo2.png'

const container = document.createElement('div')
container.setAttribute('class', 'container')

app.appendChild(logo)
app.appendChild(container)

var request = new XMLHttpRequest()
request.open('GET', 'http://localhost:8080/images', true)

request.onload = function() {
  // Begin accessing JSON data here

  var data = JSON.parse(this.response)
  if (request.status >= 200 && request.status < 400) {
    data.forEach(image => {

    	console.log(image)
      const card = document.createElement('div')
      card.setAttribute('class', 'card')

      const h1 = document.createElement('h1')
      h1.textContent = image.userName

     //const img = document.createElement('img')
      var myImage = new Image();
      myImage.src = image.url;
      console.log(myImage)
      container.appendChild(card)
      card.appendChild(h1)
      card.appendChild(myImage)
      
    })
  } else {
    const errorMessage = document.createElement('marquee')
    errorMessage.textContent = `Gah, it's not working!`
    app.appendChild(errorMessage)
  }
}

request.send()