import * as jQuery from './jquery.js';

window.jQuery = jQuery;

export class Exhibit {
  constructor() {
    this.init();
  }

  init() {
    $.get('./exampleSentences.json', data => {
      console.log(data);
      this.showExampleChinese(data);
    })

  }

  showExampleChinese(data) {
    Object.keys(data).forEach(sectionKey => {
      // create Section
      let sectionDiv = document.createElement("div");
      let sectionTitle = document.createElement("div")
      sectionTitle.innerText = "书-" + sectionKey;
      sectionTitle.style.cursor = "pointer"
      sectionTitle.style.fontSize = "35px"
      sectionTitle.style.backgroundColor = "cadetblue"
      sectionTitle.addEventListener("click", function (event) {
        $(this.nextSibling).toggle();
      })

      sectionDiv.append(sectionTitle)

      let sectionContent = document.createElement("div")

      Object.keys(data[sectionKey]).forEach(unitKey => {
        // create unit for section
        let unitDiv = document.createElement("div")
        let unitTitle = document.createElement("div")
        unitTitle.innerText = "Unit-" + unitKey
        unitTitle.style.cursor = "pointer"
        unitTitle.style.fontSize = "25px"
        unitTitle.style.backgroundColor = 'beige'
        unitTitle.addEventListener("click", function (event) {
          $(this.nextSibling).toggle()
        })

        unitDiv.append(unitTitle)

        let unitContent = document.createElement("div")


        data[sectionKey][unitKey].forEach((sentence, index) => {
          // crate sentence for unit
          let sentenceDiv = document.createElement("div")
          sentenceDiv.innerHTML = `
           <span>${index}. ${sentence['chinese']}</span> 
           <button id="english-${sectionKey}-${unitKey}-${index}" title="${sentence['sentence']}">英文</button>
           <button title=${sentence['keyword']}>关键词</button>
           <span id="result-${sectionKey}-${unitKey}-${index}"></span>
          `

          let englishInput = document.createElement("input");
          englishInput.style.display = "block"
          englishInput.style.width = "100%"
          englishInput.style.fontSize = "15px"
          englishInput.style.marginBottom = "10px"

          englishInput.addEventListener("keyup", function (event) {
            if (event.keyCode === 13) {
              if (this.value.replace(" ", '') === $(`#english-${sectionKey}-${unitKey}-${index}`).attr("title").replace(" ", '')) {
                this.style.borderColor = "green";
              } else {
                this.style.borderColor = "red";
              }
            }
          })
          sentenceDiv.append(englishInput)
          unitContent.append(sentenceDiv)
          unitDiv.append(unitContent)
        })
        sectionContent.append(unitDiv)
        sectionDiv.append(sectionContent)
      })

      $("#content").append(sectionDiv);

    })
  }

}