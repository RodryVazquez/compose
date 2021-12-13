package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import kotlin.text.Typography.section

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Conversation(messages = SampleData.conversationSample)
            }
        }
    }

    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Contact Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // We keep track if the message is expanded or not in this
            // variable
            var isExpanded by remember { mutableStateOf(false) }
            // surfaceColor will be updated gradually from one color to the other
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
            )

            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = msg.author,
                        color = MaterialTheme.colors.secondary,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(1.dp)
                    )

                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_turned_in_not),
                            contentDescription = "Contact Profile Picture",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_more),
                            contentDescription = "Contact Profile Picture",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }

                Text(
                    text = msg.date,
                    style = TextStyle(
                        fontSize = 10.sp
                    ),
                    modifier = Modifier.padding(1.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = msg.body,
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .clickable { isExpanded = !isExpanded },
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun previewMessageCard() {
        ComposeTutorialTheme {
            MessageCard(
                msg = Message(
                    "Colleague",
                    "2021-11-12",
                    "Hey, take a look at Jetpack Compose"
                )
            )
        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun Conversation(messages: List<Message>) {
        val grouped = messages.sortedBy { it.date }.groupBy { it.date }
        LazyColumn {
            grouped.forEach { (date, dateMessages) ->
                stickyHeader {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                            Divider(color = Color.Blue, thickness = 1.dp,
                                modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(8.dp).weight(1f)
                            )
                            Text(
                                text = date,
                                color = Color.Gray,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(8.dp).weight(1f)
                            )
                            Divider(color = Color.Blue, thickness = 1.dp,  modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(8.dp).weight(1f)
                            )
                    }
                }

                items(
                    dateMessages
                ) { message ->
                    MessageCard(msg = message)
                }
            }
        }
    }

    @ExperimentalFoundationApi
    @Preview
    @Composable
    fun PreviewConversation() {
        ComposeTutorialTheme {
            Conversation(SampleData.conversationSample)
        }
    }

}